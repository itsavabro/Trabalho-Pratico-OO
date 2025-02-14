package menus;

import metodos.GerenciadorMedicamentos;
import classes.Consulta;
import java.util.List;
import java.util.Scanner;

public class MenuMedicamentos {
    public static void exibirMenu(List<Consulta> consultas, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciamento de Medicamentos");
            System.out.println("1 - Prescrever medicamento");
            System.out.println("2 - Buscar medicamento");
            System.out.println("3 - Remover medicamento");
            System.out.println("4 - Atualizar medicamento");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            
            switch (opcao) {
                case 1 -> GerenciadorMedicamentos.prescreverMedicamento(consultas, scanner);
                case 2 -> {
                    System.out.print("Informe o nome do medicamento: ");
                    String nome = scanner.nextLine();
                    System.out.println(GerenciadorMedicamentos.buscarMedicamento(consultas, nome) != null ? "Medicamento encontrado." : "Medicamento não encontrado.");
                }
                case 3 -> {
                    System.out.print("Informe o nome do medicamento para remover: ");
                    String nome = scanner.nextLine();
                    GerenciadorMedicamentos.removerMedicamento(consultas, nome);
                }
                case 4 -> {
                    System.out.print("Informe o nome do medicamento para atualizar: ");
                    String nome = scanner.nextLine();
                    GerenciadorMedicamentos.atualizarMedicamento(consultas, scanner, nome);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
