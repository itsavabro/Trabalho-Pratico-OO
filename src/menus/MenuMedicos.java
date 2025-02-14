package menus;

import metodos.GerenciadorMedicos;
import classes.Medico;
import java.util.List;
import java.util.Scanner;

public class MenuMedicos {
    public static void exibirMenu(List<Medico> medicos, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciamento de Médicos");
            System.out.println("1 - Cadastrar médico");
            System.out.println("2 - Buscar médico");
            System.out.println("3 - Remover médico");
            System.out.println("4 - Atualizar médico");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            
            switch (opcao) {
                case 1 -> GerenciadorMedicos.cadastrarMedico(medicos, scanner);
                case 2 -> {
                    System.out.print("Informe o CPF do médico: ");
                    String cpf = scanner.nextLine();
                    Medico medico = GerenciadorMedicos.buscarMedico(medicos, cpf);
                    System.out.println(medico != null ? medico : "Médico não encontrado.");
                }
                case 3 -> {
                    System.out.print("Informe o CPF do médico para remover: ");
                    String cpf = scanner.nextLine();
                    GerenciadorMedicos.removerMedico(medicos, cpf);
                }
                case 4 -> {
                    System.out.print("Informe o CPF do médico para atualizar: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova especialidade: ");
                    String novaEspecialidade = scanner.nextLine();
                    GerenciadorMedicos.atualizarMedico(medicos, cpf, novoNome, novaEspecialidade);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}