package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends PessoaFisica {
    private List<Consulta> historicoConsultas;
    private List<Exame> historicoExames;
    private boolean pagamentoPendente;

    public Paciente(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.historicoConsultas = new ArrayList<>();
        this.historicoExames = new ArrayList<>();
        this.pagamentoPendente = false;
    }

    public List<Consulta> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        historicoConsultas.add(consulta);
    }

    public List<Exame> getHistoricoExames() {
        return historicoExames;
    }

    public void adicionarExame(Exame exame) {
        historicoExames.add(exame);
    }

    public boolean temPagamentoPendente() {
        return pagamentoPendente;
    }

    public void registrarPagamento() {
        this.pagamentoPendente = false;
    }

    public void marcarPagamentoPendente() {
        this.pagamentoPendente = true;
    }

    @Override
    public String toString() {
        return "Paciente: " + nome + " | CPF: " + cpf + " | Data de Nascimento: " + dataNascimento +
               " | Pagamento Pendente: " + (pagamentoPendente ? "Sim" : "Não");
    }
}
