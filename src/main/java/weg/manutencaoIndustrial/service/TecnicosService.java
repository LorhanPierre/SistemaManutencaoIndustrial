package weg.manutencaoIndustrial.service;

import weg.manutencaoIndustrial.dao.TecnicosDAO;
import weg.manutencaoIndustrial.model.Tecnicos;
import weg.manutencaoIndustrial.view.Inputs;

import java.sql.SQLException;

public class TecnicosService {

    Inputs inputs = new Inputs();

    public void CadastrarTecnico() throws SQLException {

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃               Área Cadastro de Técnico               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        var tecnico = new TecnicosDAO();

        boolean valorValidado = false;
        while(!valorValidado){
            String nome = inputs.inputNomeTecnico();
            String especialidade = inputs.inputEspecialidade();

            try{
                if(tecnico.ValidarTecnico(nome,especialidade)){
                    System.out.println("\u001b[31m| Já existe um técnico com esse nome e essa especialidade\u001b[0m");
                }else{
                    var Tecnicos = new Tecnicos(nome,especialidade);
                    tecnico.CadastrarTecnico(Tecnicos);
                    System.out.println("\u001b[32m| Técnico cadastrado com Sucesso!\u001b[0m");
                    valorValidado = true;
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws SQLException {
        var tecnico = new TecnicosService();
        tecnico.CadastrarTecnico();
    }
}
