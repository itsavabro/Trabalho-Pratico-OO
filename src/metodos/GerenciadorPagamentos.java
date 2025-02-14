package metodos;

import classes.Consulta;
import classes.Exame;
import java.util.List;
import java.util.Scanner;

public class GerenciadorPagamentos {
    public static void realizarPagamentoConsulta(List<Consulta> consultas, Scanner scanner) {
        System.out.print("Informe a data e hora da consulta (AAAA-MM-DDTHH:MM): ");
        String dataHora = scanner.nextLine();
        Consulta consulta = consultas.stream().filter(c -> c.getDataHora().toString().equals(dataHora)).findFirst().orElse(null);
        
        if (consulta == null) {
            System.out.println("Consulta não encontrada.");
            return;
        }
        
        if (consulta.isPaga()) {
            System.out.println("Esta consulta já foi paga.");
            return;
        }
        
        System.out.print("Informe o valor pago: ");
        float valorPago = scanner.nextFloat();
        scanner.nextLine();
        
        if (valorPago >= consulta.getValorConsulta()) {
            consulta.setPaga(true);
            System.out.println("Pagamento realizado com sucesso.");
        } else {
            System.out.println("Valor insuficiente para pagamento da consulta.");
        }
    }

    public static void realizarPagamentoExame(List<Consulta> consultas, Scanner scanner) {
        System.out.print("Informe a data e hora da consulta (AAAA-MM-DDTHH:MM): ");
        String dataHora = scanner.nextLine();
        Consulta consulta = consultas.stream().filter(c -> c.getDataHora().toString().equals(dataHora)).findFirst().orElse(null);
        
        if (consulta == null) {
            System.out.println("Consulta não encontrada.");
            return;
        }
        
        System.out.println("Exames desta consulta:");
        List<Exame> exames = consulta.getExamesPrescritos();
        if (exames.isEmpty()) {
            System.out.println("Nenhum exame associado a esta consulta.");
            return;
        }
        
        for (int i = 0; i < exames.size(); i++) {
            System.out.println((i + 1) + " - " + exames.get(i).getTipo() + " | Custo: " + exames.get(i).getCusto());
        }
        
        System.out.print("Escolha o número do exame a pagar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        
        if (escolha < 1 || escolha > exames.size()) {
            System.out.println("Escolha inválida.");
            return;
        }
        
        Exame exame = exames.get(escolha - 1);
        System.out.print("Informe o valor pago: ");
        float valorPago = scanner.nextFloat();
        scanner.nextLine();
        
        if (valorPago >= exame.getCusto()) {
            exame.setPago(true);
            System.out.println("Pagamento do exame realizado com sucesso.");
        } else {
            System.out.println("Valor insuficiente para pagamento do exame.");
        }
    }
}
