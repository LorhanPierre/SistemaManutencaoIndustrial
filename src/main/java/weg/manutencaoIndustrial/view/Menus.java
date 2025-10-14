package weg.manutencaoIndustrial.view;

import static weg.manutencaoIndustrial.utils.Utils.inputNumber;

public class Menus {

    public int MenuInicial(){
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃         WEG Manutencao Industrial        ┃");
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("┃                  opções                  ┃");
        System.out.println("┣------------------------------------------┫");
        System.out.println("┃ 1 - Cadastrar Máquina                    ┃");
        System.out.println("┃ 2 - Cadastrar Técnico                    ┃");
        System.out.println("┃ 3 - Cadastrar Peça                       ┃");
        System.out.println("┃ 4 - Criar Ordem de Manutenção            ┃");
        System.out.println("┃ 5 - Associar Peças à ordem               ┃");
        System.out.println("┃ 6 - Executar Manutenção                  ┃");
        System.out.println("┃                                          ┃");
        System.out.println("┃ 0 - sair                                 ┃");
        System.out.print  ("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n:");

        return inputNumber();
    }
}
