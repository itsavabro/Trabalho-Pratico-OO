package menus;

import metodos.GerenciadorPacientes;
import classes.Paciente;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class MenuPacientes {
    public static void exibirMenu(List<Paciente> pacientes, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciamento de Pacientes");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Buscar paciente");
            System.out.println("3 - Remover paciente");
            System.out.println("4 - Atualizar paciente");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            
            switch (opcao) {
                case 1 -> GerenciadorPacientes.cadastrarPaciente(pacientes, scanner);
                case 2 -> {
                    System.out.print("Informe o CPF do paciente: ");
                    String cpf = scanner.nextLine();
                    Paciente paciente = GerenciadorPacientes.buscarPaciente(pacientes, cpf);
                    System.out.println(paciente != null ? paciente : "Paciente não encontrado.");
                }
                case 3 -> {
                    System.out.print("Informe o CPF do paciente para remover: ");
                    String cpf = scanner.nextLine();
                    GerenciadorPacientes.removerPaciente(pacientes, cpf);
                }
                case 4 -> {
                    System.out.print("Informe o CPF do paciente para atualizar: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova data de nascimento (YYYY-MM-DD): ");
                    LocalDate novaDataNascimento = LocalDate.parse(scanner.nextLine());
                    GerenciadorPacientes.atualizarPaciente(pacientes, cpf, novoNome, novaDataNascimento);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}