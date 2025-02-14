package classes;

import java.time.LocalDate;

public class Exame {
    private String tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultado;
    private float custo;
    private boolean pago;

    public Exame(String tipo, LocalDate dataPrescricao, LocalDate dataRealizacao, String resultado, float custo) {
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultado = resultado;
        this.custo = custo;
        this.pago = false;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(LocalDate dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
