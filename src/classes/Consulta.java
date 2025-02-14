package classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private LocalDateTime dataHora;
    private String status;
    private Paciente paciente;
    private Medico medico;
    private List<Exame> examesPrescritos;
    private List<Medicamento> medicamentosPrescritos;
    private float valorConsulta;
    private boolean paga;

    public Consulta(LocalDateTime dataHora, String status, Paciente paciente, Medico medico, float valorConsulta) {
        this.dataHora = dataHora;
        this.status = status;
        this.paciente = paciente;
        this.medico = medico;
        this.examesPrescritos = new ArrayList<>();
        this.medicamentosPrescritos = new ArrayList<>();
        this.valorConsulta = valorConsulta;
        this.paga = false;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public float getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public void adicionarExame(Exame exame) {
        examesPrescritos.add(exame);
    }

    public List<Exame> getExamesPrescritos() {
        return examesPrescritos;
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        medicamentosPrescritos.add(medicamento);
    }

    public List<Medicamento> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }
}
