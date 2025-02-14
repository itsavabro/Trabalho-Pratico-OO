package classes;

public class Pagamento {
    private Consulta consulta;
    private float valor;
    private boolean pago;

    public Pagamento(Consulta consulta) {
        this.consulta = consulta;
        this.valor = consulta.getValorConsulta();
        this.pago = false;
    }

    public void realizarPagamento(float valorPago) {
        if (valorPago >= this.valor) {
            this.pago = true;
            consulta.setPaga(true);
            System.out.println("Pagamento realizado com sucesso.");
        } else {
            System.out.println("Valor insuficiente para pagamento.");
        }
    }

    public boolean isPago() {
        return pago;
    }

    public float getValor() {
        return valor;
    }
}
