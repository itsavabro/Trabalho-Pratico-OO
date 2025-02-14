package metodos;

import classes.Medico;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class GerenciadorMedicos {
    public static void cadastrarMedico(List<Medico> medicos, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Data de Nascimento (YYYY-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        if (medicos.stream().anyMatch(m -> m.getCpf().equals(cpf))) {
            System.out.println("CPF já cadastrado.");
            return;
        }

        medicos.add(new Medico(nome, cpf, dataNascimento, crm, especialidade));
        System.out.println("Médico cadastrado com sucesso.");
    }

    public static void cadastrarMedico(List<Medico> medicos, String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
        if (medicos.stream().anyMatch(m -> m.getCpf().equals(cpf))) {
            System.out.println("CPF já cadastrado.");
            return;
        }
        medicos.add(new Medico(nome, cpf, dataNascimento, crm, especialidade));
        System.out.println("Médico cadastrado com sucesso.");
    }

    public static Medico buscarMedico(List<Medico> medicos, String cpf) {
        return medicos.stream().filter(m -> m.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public static void removerMedico(List<Medico> medicos, String cpf) {
        Medico medico = buscarMedico(medicos, cpf);
        if (medico != null) {
            medicos.remove(medico);
            System.out.println("Médico removido com sucesso.");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    public static void atualizarMedico(List<Medico> medicos, Scanner scanner, String cpf) {
        Medico medico = buscarMedico(medicos, cpf);
        if (medico != null) {
            System.out.print("Novo nome: ");
            medico.setNome(scanner.nextLine());
            System.out.print("Nova especialidade: ");
            medico.setEspecialidade(scanner.nextLine());
            System.out.println("Dados do médico atualizados com sucesso.");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    public static void atualizarMedico(List<Medico> medicos, String cpf, String novoNome, String novaEspecialidade) {
        Medico medico = buscarMedico(medicos, cpf);
        if (medico != null) {
            medico.setNome(novoNome);
            medico.setEspecialidade(novaEspecialidade);
            System.out.println("Dados do médico atualizados com sucesso.");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}
