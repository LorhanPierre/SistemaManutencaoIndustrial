package weg.manutencaoIndustrial.controller;

import weg.manutencaoIndustrial.service.MaquinasService;
import weg.manutencaoIndustrial.service.PecasService;
import weg.manutencaoIndustrial.service.TecnicosService;
import weg.manutencaoIndustrial.view.Menus;

import java.sql.SQLException;

import static weg.manutencaoIndustrial.view.Mensagens.Agradecimento;
import static weg.manutencaoIndustrial.view.Mensagens.OpcaoInvalida;

public class ManutencaoSystem {

    public void applicattion() throws SQLException {
        var menu = new Menus();
        var maquina = new MaquinasService();
        var tecnicos = new TecnicosService();
        var pecas = new PecasService();
        boolean endSystem = false;

        while(!endSystem){
            switch (menu.MenuInicial()){
                case 1 ->{
                    maquina.CadastrarMaquina();
                }
                case 2 ->{
                    tecnicos.CadastrarTecnico();
                }
                case 3 ->{
                    pecas.CadastrarPeca();
                }
                case 4 ->{}
                case 5 ->{}
                case 6 ->{}
                case 0 ->{
                    Agradecimento();
                    endSystem = true;
                }
                default ->{
                    OpcaoInvalida();
                }
            }
        }
    }

}
