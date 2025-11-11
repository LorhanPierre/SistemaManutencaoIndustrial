package weg.manutencaoIndustrial.controller;

import weg.manutencaoIndustrial.model.OrdensManutencao;
import weg.manutencaoIndustrial.service.*;
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
        var ordem = new OrdensManutencaoService();
        var ordemPeca = new OrdemPecasService();
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
                case 4 ->{
                    ordem.CriarOrdensManutencao();
                }
                case 5 ->{
                    ordemPeca.AssociarPecasOrdem();
                }
                case 6 ->{
                    ordem.ExecutarManutencao();
                }
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
