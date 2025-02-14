package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Medico extends PessoaFisica {
    private String crm;
    private String especialidade;
    private List<Consulta> historicoConsultas;

    public Medico(String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
        super(nome, cpf, dataNascimento);
        this.crm = crm;
        this.especialidade = especialidade;
        this.historicoConsultas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Médico: " + nome + " | CPF: " + cpf + " | CRM: " + crm + " | Especialidade: " + especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void adicionarConsulta(Consulta consulta) {
        historicoConsultas.add(consulta);
    }
}