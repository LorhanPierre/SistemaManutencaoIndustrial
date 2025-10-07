package weg.manutencaoIndustrial.model;

public class Pecas {

    private int idPeca;
    private String nomePeca;
    private double estoquePeca;

    public Pecas(int idPeca, String nomePeca, double estoquePeca) {
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.estoquePeca = estoquePeca;
    }

    public Pecas(String nomePeca, double estoquePeca) {
        this.nomePeca = nomePeca;
        this.estoquePeca = estoquePeca;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public double getEstoquePeca() {
        return estoquePeca;
    }

    public void setEstoquePeca(double estoquePeca) {
        this.estoquePeca = estoquePeca;
    }
}
