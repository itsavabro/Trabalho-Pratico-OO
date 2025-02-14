package metodos;

import classes.Consulta;
import classes.Exame;
import exceptions.PagamentoPendenteException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class GerenciadorExames {
    public static void prescreverExame(List<Consulta> consultas, Scanner scanner) {
        try {
            System.out.print("Informe a data e hora da consulta (AAAA-MM-DDTHH:MM): ");
            String dataHora = scanner.nextLine();
            Consulta consulta = consultas.stream().filter(c -> c.getDataHora().toString().equals(dataHora)).findFirst().orElse(null);
            
            if (consulta == null) {
                System.out.println("Consulta não encontrada.");
                return;
            }
            
            if (consulta.getPaciente().temPagamentoPendente()) {
                throw new PagamentoPendenteException("Paciente possui pendências financeiras e não pode realizar exames.");
            }
            
            System.out.print("Informe o tipo de exame: ");
            String tipo = scanner.nextLine();
            System.out.print("Informe a data de realização (AAAA-MM-DD): ");
            LocalDate dataRealizacao = LocalDate.parse(scanner.nextLine());
            System.out.print("Informe o resultado do exame: ");
            String resultado = scanner.nextLine();
            System.out.print("Informe o custo do exame: ");
            float custo = scanner.nextFloat();
            scanner.nextLine();
            
            Exame exame = new Exame(tipo, LocalDate.now(), dataRealizacao, resultado, custo);
            consulta.adicionarExame(exame);
            System.out.println("Exame prescrito com sucesso.");
        } catch (PagamentoPendenteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Exame buscarExame(List<Consulta> consultas, String tipo) {
        for (Consulta consulta : consultas) {
            for (Exame exame : consulta.getExamesPrescritos()) {
                if (exame.getTipo().equalsIgnoreCase(tipo)) {
                    return exame;
                }
            }
        }
        return null;
    }

    public static void removerExame(List<Consulta> consultas, String tipo) {
        for (Consulta consulta : consultas) {
            consulta.getExamesPrescritos().removeIf(exame -> exame.getTipo().equalsIgnoreCase(tipo));
        }
        System.out.println("Exame removido com sucesso.");
    }

    public static void atualizarExame(List<Consulta> consultas, Scanner scanner, String tipo) {
        Exame exame = buscarExame(consultas, tipo);
        if (exame != null) {
            System.out.print("Novo resultado: ");
            exame.setResultado(scanner.nextLine());
            System.out.print("Novo custo: ");
            exame.setCusto(scanner.nextFloat());
            scanner.nextLine();
            System.out.println("Exame atualizado com sucesso.");
        } else {
            System.out.println("Exame não encontrado.");
        }
    }
}

