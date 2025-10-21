package weg.manutencaoIndustrial.service;

import weg.manutencaoIndustrial.dao.OrdemPecasDAO;
import weg.manutencaoIndustrial.dao.OrdensManutencaoDAO;
import weg.manutencaoIndustrial.dao.PecasDAO;
import weg.manutencaoIndustrial.dto.OrdensPendente;
import weg.manutencaoIndustrial.model.OrdemPecas;
import weg.manutencaoIndustrial.model.Pecas;
import weg.manutencaoIndustrial.utils.Utils;

import java.sql.SQLException;
import java.util.List;

public class OrdemPecasService {

    Utils util = new Utils();

    public void AssociarPecasOrdem() throws SQLException {

        var ordem = new OrdensManutencaoDAO();
        List<OrdensPendente> listOrdensPendentes  = ordem.ListarOrdensPendente();

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃  Área de Associação de Peças a Ordens de Manutenção  ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃            Escolha uma Ordem de Manutenção           ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        for(OrdensPendente pendente : listOrdensPendentes){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("- ID               : "+pendente.id());
            System.out.println("-----------------------------------------------------");
            System.out.println("- ID Máquina       : "+pendente.idMaquina());
            System.out.println("-----------------------------------------------------");
            System.out.println("- ID Técnico       : "+pendente.idTecnico());
            System.out.println("-----------------------------------------------------");
            System.out.println("- Data Solicitação : "+pendente.dataSolicitacao());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }
        int idOrdem = 0;
        boolean validarIdOrdem = false;
        while(!validarIdOrdem){
            System.out.print("| Digite sua escolha:");
            idOrdem = util.inputNumber();
            if(ordem.validaIdOrdem(idOrdem)){
                validarIdOrdem = true;
            }else{
                System.out.println("\u001b[31m| ID não existe! Tente novamente!\u001b[0m");
            }
        }

        var pecas = new PecasDAO();
        List<Pecas> listPecas = pecas.listarPecas();

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       Escolha as Peças para a Ordem Escolhida        ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        for(Pecas lista : listPecas){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("- ID                    : "+lista.getIdPeca());
            System.out.println("-----------------------------------------------------");
            System.out.println("- Nome Peça             : "+lista.getNomePeca());
            System.out.println("-----------------------------------------------------");
            System.out.println("- Quantidade em Estoque : "+lista.getEstoquePeca());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }

        boolean fimAdicaoPecas = false;
        while(!fimAdicaoPecas){
            int idPeca = 0;
            boolean validarIdPeca = false;
            while(!validarIdPeca){
                System.out.print("| Digite sua escolha:");
                idPeca = util.inputNumber();
                if(pecas.validarIdPeca(idPeca)){
                    System.out.print("| Digite a quantidade necessária: ");
                    int quantidade = util.inputNumber();

                   try{
                       var OrdemPecaDAO = new OrdemPecasDAO();
                       var OrdemPeca = new OrdemPecas(idOrdem,idPeca,quantidade);

                       OrdemPecaDAO.CriarOrdemPecas(OrdemPeca);
                       System.out.println("\u001b[32m| Peça adicionada com sucesso!\u001b[0m");
                   }catch(SQLException ex){
                       ex.printStackTrace();
                   }

                   System.out.println("| Deseja Adicionar mais peças?\n 1 - Sim     2 - Não");
                   int addMaisPecas = util.inputNumber();
                   if (addMaisPecas == 2){
                       fimAdicaoPecas = true;
                   }
                   validarIdPeca = true;
                }else{
                    System.out.println("\u001b[31m| ID não existe! Tente novamente!\u001b[0m");
                }
            }

        }


    }

}
