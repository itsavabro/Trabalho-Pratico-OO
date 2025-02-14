package metodos;

import classes.Paciente;
import classes.Medico;
import classes.Consulta;
import exceptions.HorarioIndisponivelException;
import exceptions.PagamentoPendenteException;
import exceptions.EspecialidadeInvalidaException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class GerenciadorConsultas {
    public static void agendarConsulta(List<Paciente> pacientes, List<Medico> medicos, List<Consulta> consultas, Scanner scanner) {
        try {
            if (pacientes.isEmpty() || medicos.isEmpty()) {
                System.out.println("Cadastre pacientes e médicos antes de agendar uma consulta.");
                return;
            }

            System.out.print("CPF do Paciente: ");
            String cpfPaciente = scanner.nextLine();
            Paciente paciente = pacientes.stream().filter(p -> p.getCpf().equals(cpfPaciente)).findFirst().orElse(null);
            if (paciente == null) {
                System.out.println("Paciente não encontrado.");
                return;
            }

            if (paciente.temPagamentoPendente()) {
                throw new PagamentoPendenteException("Paciente possui pendências financeiras e não pode agendar consultas.");
            }

            System.out.print("CPF do Médico: ");
            String cpfMedico = scanner.nextLine();
            Medico medico = medicos.stream().filter(m -> m.getCpf().equals(cpfMedico)).findFirst().orElse(null);
            if (medico == null) {
                System.out.println("Médico não encontrado.");
                return;
            }

            System.out.print("Especialidade necessária: ");
            String especialidade = scanner.nextLine();
            if (!medico.getEspecialidade().equalsIgnoreCase(especialidade)) {
                throw new EspecialidadeInvalidaException("O médico selecionado não possui a especialidade necessária.");
            }

            System.out.print("Data e Hora da Consulta (AAAA-MM-DDTHH:MM): ");
            LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine());
            System.out.print("Valor da Consulta: ");
            float valor = scanner.nextFloat();
            scanner.nextLine();

            for (Consulta consulta : consultas) {
                if (consulta.getMedico().equals(medico) && consulta.getDataHora().equals(dataHora)) {
                    throw new HorarioIndisponivelException("O médico já possui uma consulta agendada neste horário.");
                }
            }

            Consulta novaConsulta = new Consulta(dataHora,"AGENDADA", paciente, medico, valor);
            consultas.add(novaConsulta);
            paciente.adicionarConsulta(novaConsulta);
            medico.adicionarConsulta(novaConsulta);
            System.out.println("Consulta agendada com sucesso.");
        } catch (PagamentoPendenteException | EspecialidadeInvalidaException | HorarioIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Consulta buscarConsulta(List<Consulta> consultas, LocalDateTime dataHora, String cpfPaciente) {
        return consultas.stream().filter(c -> c.getDataHora().equals(dataHora) && c.getPaciente().getCpf().equals(cpfPaciente)).findFirst().orElse(null);
    }

    public static void removerConsulta(List<Consulta> consultas, LocalDateTime dataHora, String cpfPaciente) {
        Consulta consulta = buscarConsulta(consultas, dataHora, cpfPaciente);
        if (consulta != null) {
            consultas.remove(consulta);
            System.out.println("Consulta removida com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    public static void atualizarConsulta(List<Consulta> consultas, Scanner scanner, LocalDateTime dataHora, String cpfPaciente) {
        Consulta consulta = buscarConsulta(consultas, dataHora, cpfPaciente);
        if (consulta != null) {
            System.out.print("Novo valor da consulta: ");
            consulta.setValorConsulta(scanner.nextFloat());
            scanner.nextLine();
            System.out.println("Consulta atualizada com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}

