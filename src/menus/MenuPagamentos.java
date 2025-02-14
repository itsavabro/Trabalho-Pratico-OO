package menus;

import metodos.GerenciadorPagamentos;
import classes.Consulta;
import java.util.List;
import java.util.Scanner;

public class MenuPagamentos {
    public static void exibirMenu(List<Consulta> consultas, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciamento de Pagamentos");
            System.out.println("1 - Pagar consulta");
            System.out.println("2 - Pagar exame");
            System.out.println("3 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            
            switch (opcao) {
                case 1 -> GerenciadorPagamentos.realizarPagamentoConsulta(consultas, scanner);
                case 2 -> GerenciadorPagamentos.realizarPagamentoExame(consultas, scanner);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
