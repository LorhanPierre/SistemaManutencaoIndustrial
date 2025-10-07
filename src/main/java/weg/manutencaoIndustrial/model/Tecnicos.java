package weg.manutencaoIndustrial.model;

public class Tecnicos {

    private int idTecnico;
    private String nomeTecnico;
    private String especialidadeTecnico;

    public Tecnicos(int idTecnico, String nomeTecnico, String especialidadeTecnico) {
        this.idTecnico = idTecnico;
        this.nomeTecnico = nomeTecnico;
        this.especialidadeTecnico = especialidadeTecnico;
    }

    public Tecnicos(String nomeTecnico, String especialidadeTecnico) {
        this.nomeTecnico = nomeTecnico;
        this.especialidadeTecnico = especialidadeTecnico;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getEspecialidadeTecnico() {
        return especialidadeTecnico;
    }

    public void setEspecialidadeTecnico(String especialidadeTecnico) {
        this.especialidadeTecnico = especialidadeTecnico;
    }
}
