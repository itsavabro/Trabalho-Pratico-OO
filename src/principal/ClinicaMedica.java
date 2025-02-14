package principal;

import menus.MenuPacientes;
import menus.MenuMedicos;
import menus.MenuConsultas;
import menus.MenuExames;
import menus.MenuMedicamentos;
import menus.MenuPagamentos;
import classes.Paciente;
import classes.Medico;
import classes.Consulta;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicaMedica {
    static Scanner scanner = new Scanner(System.in);
    static List<Paciente> pacientes = new ArrayList<>();
    static List<Medico> medicos = new ArrayList<>();
    static List<Consulta> consultas = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSistema de Clínica Médica");
            System.out.println("1 - Gerenciar Pacientes");
            System.out.println("2 - Gerenciar Médicos");
            System.out.println("3 - Gerenciar Consultas");
            System.out.println("4 - Gerenciar Exames");
            System.out.println("5 - Gerenciar Medicamentos");
            System.out.println("6 - Gerenciar Pagamentos");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            
            switch (opcao) {
                case 1 -> MenuPacientes.exibirMenu(pacientes, scanner);
                case 2 -> MenuMedicos.exibirMenu(medicos, scanner);
                case 3 -> MenuConsultas.exibirMenu(pacientes, medicos, consultas, scanner);
                case 4 -> MenuExames.exibirMenu(consultas, scanner);
                case 5 -> MenuMedicamentos.exibirMenu(consultas, scanner);
                case 6 -> MenuPagamentos.exibirMenu(consultas, scanner);
                case 7 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
