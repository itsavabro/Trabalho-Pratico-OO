package menus;

import metodos.GerenciadorConsultas;
import classes.Consulta;
import classes.Paciente;
import classes.Medico;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class MenuConsultas {
    public static void exibirMenu(List<Paciente> pacientes, List<Medico> medicos, List<Consulta> consultas, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciamento de Consultas");
            System.out.println("1 - Agendar consulta");
            System.out.println("2 - Buscar consulta");
            System.out.println("3 - Remover consulta");
            System.out.println("4 - Atualizar consulta");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            
            switch (opcao) {
                case 1 -> GerenciadorConsultas.agendarConsulta(pacientes, medicos, consultas, scanner);
                case 2 -> {
                    System.out.print("Informe a data e hora da consulta (AAAA-MM-DDTHH:MM): ");
                    LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Informe o CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    Consulta consulta = GerenciadorConsultas.buscarConsulta(consultas, dataHora, cpfPaciente);
                    System.out.println(consulta != null ? consulta : "Consulta não encontrada.");
                }
                case 3 -> {
                    System.out.print("Informe a data e hora da consulta (AAAA-MM-DDTHH:MM) para remover: ");
                    LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Informe o CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    GerenciadorConsultas.removerConsulta(consultas, dataHora, cpfPaciente);
                }
                case 4 -> {
                    System.out.print("Informe a data e hora da consulta (AAAA-MM-DDTHH:MM) para atualizar: ");
                    LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Informe o CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    GerenciadorConsultas.atualizarConsulta(consultas, scanner, dataHora, cpfPaciente);
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
