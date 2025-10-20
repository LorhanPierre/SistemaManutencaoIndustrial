package weg.manutencaoIndustrial.service;

import weg.manutencaoIndustrial.dao.PecasDAO;
import weg.manutencaoIndustrial.model.Pecas;
import weg.manutencaoIndustrial.view.Inputs;

import java.sql.SQLException;

public class PecasService {

    Inputs inputs = new Inputs();

    public void CadastrarPeca() throws SQLException {

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃              Área de Cadastro de Peças               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        var peca = new PecasDAO();

        boolean valorValido = false;
        while(!valorValido){

            String nomePeca = inputs.inputNomePeca();

            try{
                if(peca.validacaoPeca(nomePeca)){
                    System.out.println("\u001b[31m| Já existe uma peça cadastrada com esse nome\u001b[0m");
                }else{
                    double quantInicialPecas = inputs.inputQuantidadeIncialPeca();
                    var Pecas = new Pecas(nomePeca, quantInicialPecas);
                    peca.CadastrarPeca(Pecas);
                    System.out.println("\u001b[32m| Peça cadastrada com Sucesso!\u001b[0m");
                    valorValido = true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
