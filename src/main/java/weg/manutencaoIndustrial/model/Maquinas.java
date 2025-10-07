package weg.manutencaoIndustrial.model;

import weg.manutencaoIndustrial.model.enums.StatusMaquinas;

public class Maquinas {

    private int idMaquina;
    private String nomeMaquina;
    private String setor;
    private StatusMaquinas statusMaquina;

    public Maquinas(int idMaquina, String nomeMaquina, String setor, StatusMaquinas statusMaquina) {
        this.idMaquina = idMaquina;
        this.nomeMaquina = nomeMaquina;
        this.setor = setor;
        this.statusMaquina = StatusMaquinas.OPERACIONAL;
    }

    public Maquinas(String nomeMaquina, String setor, StatusMaquinas statusMaquina) {
        this.nomeMaquina = nomeMaquina;
        this.setor = setor;
        this.statusMaquina = StatusMaquinas.OPERACIONAL;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public StatusMaquinas getStatusMaquina() {
        return statusMaquina;
    }

    public void setStatusMaquina(StatusMaquinas statusMaquina) {
        this.statusMaquina = statusMaquina;
    }

}
