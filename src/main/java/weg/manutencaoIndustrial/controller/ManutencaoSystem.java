package weg.manutencaoIndustrial.controller;

import weg.manutencaoIndustrial.service.MaquinasService;
import weg.manutencaoIndustrial.view.Menus;

import static weg.manutencaoIndustrial.view.Mensagens.Agradecimento;
import static weg.manutencaoIndustrial.view.Mensagens.OpcaoInvalida;

public class ManutencaoSystem {

    public void applicattion(){
        var menu = new Menus();
        var maquina = new MaquinasService();
        boolean endSystem = false;

        while(!endSystem){
            switch (menu.MenuInicial()){
                case 1 ->{
                    maquina.CadastrarMaquina();
                }
                case 2 ->{}
                case 3 ->{}
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
