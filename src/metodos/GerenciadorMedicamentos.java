package metodos;

import classes.Consulta;
import classes.Medicamento;
import java.util.List;
import java.util.Scanner;

public class GerenciadorMedicamentos {
    public static void prescreverMedicamento(List<Consulta> consultas, Scanner scanner) {
        System.out.print("Informe a data e hora da consulta (AAAA-MM-DDTHH:MM): ");
        String dataHora = scanner.nextLine();
        Consulta consulta = consultas.stream().filter(c -> c.getDataHora().toString().equals(dataHora)).findFirst().orElse(null);
        
        if (consulta == null) {
            System.out.println("Consulta não encontrada.");
            return;
        }
        
        System.out.print("Informe o nome do medicamento: ");
        String nome = scanner.nextLine();
        System.out.print("Informe a dosagem: ");
        String dosagem = scanner.nextLine();
        System.out.print("Informe as instruções: ");
        String instrucoes = scanner.nextLine();
        
        Medicamento medicamento = new Medicamento(nome, dosagem, instrucoes);
        consulta.adicionarMedicamento(medicamento);
        System.out.println("Medicamento prescrito com sucesso.");
    }

    public static Medicamento buscarMedicamento(List<Consulta> consultas, String nome) {
        for (Consulta consulta : consultas) {
            for (Medicamento medicamento : consulta.getMedicamentosPrescritos()) {
                if (medicamento.getNome().equalsIgnoreCase(nome)) {
                    return medicamento;
                }
            }
        }
        return null;
    }

    public static void removerMedicamento(List<Consulta> consultas, String nome) {
        for (Consulta consulta : consultas) {
            consulta.getMedicamentosPrescritos().removeIf(medicamento -> medicamento.getNome().equalsIgnoreCase(nome));
        }
        System.out.println("Medicamento removido com sucesso.");
    }

    public static void atualizarMedicamento(List<Consulta> consultas, Scanner scanner, String nome) {
        Medicamento medicamento = buscarMedicamento(consultas, nome);
        if (medicamento != null) {
            System.out.print("Nova dosagem: ");
            medicamento.setDosagem(scanner.nextLine());
            System.out.print("Novas instruções: ");
            medicamento.setInstrucoes(scanner.nextLine());
            System.out.println("Medicamento atualizado com sucesso.");
        } else {
            System.out.println("Medicamento não encontrado.");
        }
    }
}
