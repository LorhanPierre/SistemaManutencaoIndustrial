package weg.manutencaoIndustrial.service;

import weg.manutencaoIndustrial.dao.MaquinasDAO;
import weg.manutencaoIndustrial.dto.ValidacaoMaquina;
import weg.manutencaoIndustrial.model.Maquinas;
import weg.manutencaoIndustrial.model.enums.StatusMaquinas;
import weg.manutencaoIndustrial.view.Inputs;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MaquinasService {

    Inputs inputs = new Inputs();

    public void CadastrarMaquina(){


        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃              Área de Cadastro de Máquina             ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        var maquinas = new MaquinasDAO();

        boolean valorValidado = false;
            while(!valorValidado){
                String nome = inputs.inputNome();
                String setor = inputs.inputSetor();

                try {
                if(maquinas.validarCriacaoMaquinas(nome, setor)){
                    System.out.println("\u001b[31m| Já existe máquina com esse nome nesse setor\u001b[0m");
                }else {
                        var maquina = new Maquinas(nome, setor);
                        maquinas.CadastrarMaquinas(maquina);
                        System.out.println("\u001b[32m| Máquina cadastrada com Sucesso!\u001b[0m");
                        valorValidado = true;
                }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
    }
}
