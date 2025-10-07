package weg.manutencaoIndustrial.model;

public class OrdemPecas {

    private int idOrdemPecas;
    private int idPeca;
    private double quantidade;

    public OrdemPecas(int idOrdemPecas, int idPeca, double quantidade) {
        this.idOrdemPecas = idOrdemPecas;
        this.idPeca = idPeca;
        this.quantidade = quantidade;
    }

    public int getIdOrdemPecas() {
        return idOrdemPecas;
    }

    public void setIdOrdemPecas(int idOrdemPecas) {
        this.idOrdemPecas = idOrdemPecas;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
