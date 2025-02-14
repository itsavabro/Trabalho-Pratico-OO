package menus;

import metodos.GerenciadorExames;
import classes.Consulta;
import java.util.List;
import java.util.Scanner;

public class MenuExames {
    public static void exibirMenu(List<Consulta> consultas, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciamento de Exames");
            System.out.println("1 - Prescrever exame");
            System.out.println("2 - Buscar exame");
            System.out.println("3 - Remover exame");
            System.out.println("4 - Atualizar exame");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            
            switch (opcao) {
                case 1 -> GerenciadorExames.prescreverExame(consultas, scanner);
                case 2 -> {
                    System.out.print("Informe o tipo do exame: ");
                    String tipo = scanner.nextLine();
                    System.out.println(GerenciadorExames.buscarExame(consultas, tipo) != null ? "Exame encontrado." : "Exame não encontrado.");
                }
                case 3 -> {
                    System.out.print("Informe o tipo do exame para remover: ");
                    String tipo = scanner.nextLine();
                    GerenciadorExames.removerExame(consultas, tipo);
                }
                case 4 -> {
                    System.out.print("Informe o tipo do exame para atualizar: ");
                    String tipo = scanner.nextLine();
                    GerenciadorExames.atualizarExame(consultas, scanner, tipo);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}

