package weg.manutencaoIndustrial.model;

import weg.manutencaoIndustrial.model.enums.StatusOrdemManutencao;

import java.time.LocalDate;

public class OrdensManutencao {

    private int idOrdemPecas;
    private LocalDate dataOrdemPecas;
    private StatusOrdemManutencao statusOrdemManutencao;

    public OrdensManutencao(int idOrdemPecas, LocalDate dataOrdemPecas, StatusOrdemManutencao statusOrdemManutencao) {
        this.idOrdemPecas = idOrdemPecas;
        this.dataOrdemPecas = dataOrdemPecas;
        this.statusOrdemManutencao = statusOrdemManutencao;
    }

    public OrdensManutencao(LocalDate dataOrdemPecas, StatusOrdemManutencao statusOrdemManutencao) {
        this.dataOrdemPecas = dataOrdemPecas;
        this.statusOrdemManutencao = statusOrdemManutencao;
    }

    public int getIdOrdemPecas() {
        return idOrdemPecas;
    }

    public void setIdOrdemPecas(int idOrdemPecas) {
        this.idOrdemPecas = idOrdemPecas;
    }

    public LocalDate getDataOrdemPecas() {
        return dataOrdemPecas;
    }

    public void setDataOrdemPecas(LocalDate dataOrdemPecas) {
        this.dataOrdemPecas = dataOrdemPecas;
    }

    public StatusOrdemManutencao getStatusOrdemManutencao() {
        return statusOrdemManutencao;
    }

    public void setStatusOrdemManutencao(StatusOrdemManutencao statusOrdemManutencao) {
        this.statusOrdemManutencao = statusOrdemManutencao;
    }
}
