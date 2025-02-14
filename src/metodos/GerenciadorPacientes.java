
package metodos;

import classes.Paciente;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class GerenciadorPacientes {
    public static void cadastrarPaciente(List<Paciente> pacientes, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (YYYY-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        if (pacientes.stream().anyMatch(p -> p.getCpf().equals(cpf))) {
            System.out.println("CPF já cadastrado.");
            return;
        }

        pacientes.add(new Paciente(nome, cpf, dataNascimento));
        System.out.println("Paciente cadastrado com sucesso.");
    }

    public static void cadastrarPaciente(List<Paciente> pacientes, String nome, String cpf, LocalDate dataNascimento) {
        if (pacientes.stream().anyMatch(p -> p.getCpf().equals(cpf))) {
            System.out.println("CPF já cadastrado.");
            return;
        }
        pacientes.add(new Paciente(nome, cpf, dataNascimento));
        System.out.println("Paciente cadastrado com sucesso.");
    }

    public static Paciente buscarPaciente(List<Paciente> pacientes, String cpf) {
        return pacientes.stream().filter(p -> p.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public static void removerPaciente(List<Paciente> pacientes, String cpf) {
        Paciente paciente = buscarPaciente(pacientes, cpf);
        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static void atualizarPaciente(List<Paciente> pacientes, Scanner scanner, String cpf) {
        Paciente paciente = buscarPaciente(pacientes, cpf);
        if (paciente != null) {
            System.out.print("Novo nome: ");
            paciente.setNome(scanner.nextLine());
            System.out.print("Nova data de nascimento (YYYY-MM-DD): ");
            paciente.setDataNascimento(LocalDate.parse(scanner.nextLine()));
            System.out.println("Dados do paciente atualizados com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static void atualizarPaciente(List<Paciente> pacientes, String cpf, String novoNome, LocalDate novaDataNascimento) {
        Paciente paciente = buscarPaciente(pacientes, cpf);
        if (paciente != null) {
            paciente.setNome(novoNome);
            paciente.setDataNascimento(novaDataNascimento);
            System.out.println("Dados do paciente atualizados com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
