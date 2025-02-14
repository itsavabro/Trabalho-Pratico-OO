package classes;

public class Medicamento {
    private String nome;
    private String dosagem;
    private String instrucoes;

    public Medicamento(String nome, String dosagem, String instrucoes) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.instrucoes = instrucoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }
}
