package weg.manutencaoIndustrial.service;

import weg.manutencaoIndustrial.dao.*;
import weg.manutencaoIndustrial.dto.OrdensPendente;
import weg.manutencaoIndustrial.model.Maquinas;
import weg.manutencaoIndustrial.model.OrdemPecas;
import weg.manutencaoIndustrial.model.OrdensManutencao;
import weg.manutencaoIndustrial.model.Tecnicos;
import weg.manutencaoIndustrial.model.enums.StatusOrdemManutencao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import weg.manutencaoIndustrial.utils.Utils;

public class OrdensManutencaoService {

    Utils util = new Utils();

    public void CriarOrdensManutencao() throws SQLException {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃       Área de Criação de Ordens de Manutenção        ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        var maquina = new MaquinasDAO();
        var tecnico = new TecnicosDAO();
        List<Maquinas> maquinas = maquina.ListarMaquinasEmOperacao();
        List<Tecnicos> tecnicos = tecnico.listarTecnicos();

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                Escolha uma Máquina                   ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        for(Maquinas maquinasListadas : maquinas){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("- ID           : "+maquinasListadas.getIdMaquina());
            System.out.println("-----------------------------------------------------");
            System.out.println("- Nome Máquina : "+maquinasListadas.getNomeMaquina());
            System.out.println("-----------------------------------------------------");
            System.out.println("- Setor        : "+maquinasListadas.getSetor());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }
        int idMaquina = 0;
        boolean validarIdMaquina = false;
        while(!validarIdMaquina){
            idMaquina = util.inputNumber();
            if(maquina.validarIdMaquinas(idMaquina)){
                validarIdMaquina = true;
            }else{
                System.out.println("\u001b[31m| ID não existe! Tente novamente!\u001b[0m");
            }
        }

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                Escolha um Técnico(a)                 ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        for(Tecnicos tecnicoListados : tecnicos){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("- ID           : "+tecnicoListados.getIdTecnico());
            System.out.println("-----------------------------------------------------");
            System.out.println("- Nome Máquina : "+tecnicoListados.getNomeTecnico());
            System.out.println("-----------------------------------------------------");
            System.out.println("- Setor        : "+tecnicoListados.getEspecialidadeTecnico());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }
        int idTecnico = 0;
        boolean validarIdTecnico = false;
        while(!validarIdTecnico){
            idTecnico = util.inputNumber();
            if(tecnico.validarIdTecnico(idTecnico)){
                validarIdTecnico = true;
            }else{
                System.out.println("\u001b[31m| ID não existe! Tente novamente!\u001b[0m");
            }
        }

        var ordem = new OrdensManutencaoDAO();
        var ordens = new OrdensManutencao(LocalDate.now(), StatusOrdemManutencao.PENDENTE);
        ordem.CriarOrdensManutencao(idMaquina,idTecnico,ordens);
        maquina.alterarStatusMaquinas(idMaquina);

        System.out.println("\u001b[32m| Ordem de manutenção criada com sucesso!\u001b[0m");
    }

    public void ExecutarManutencao() throws SQLException {

        var ordem = new OrdensManutencaoDAO();
        List<OrdensPendente> listOrdensPendentes  = ordem.ListarOrdensPendente();

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃             Área de Execução de Ordens               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃            Escolha uma Ordem de Manutenção           ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        int idOrdem = 0;

        if(listOrdensPendentes.isEmpty()){
            System.out.println("\u001b[33m!Nenhuma Ordem foi associada!\u001b[0m");
            return;
        }else{
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
        }


        var estoquePecas = new OrdemPecasDAO();
        List<OrdemPecas> ordemPecas = estoquePecas.BuscarPecasPorId(idOrdem);


        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃         Análise de Disponibilidade de Peças          ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        if(ordemPecas.isEmpty()){
            System.out.println("\u001b[33m!Nenhuma peça foi associada a essa Ordem!\u001b[0m");
        }

        for(OrdemPecas pecas : ordemPecas){
            var Pecas = new PecasDAO();
            int quantidadePecasEmEstoque = Pecas.BuscarQuantidadePecas(pecas.getIdPeca());
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("- ID                       : "+pecas.getIdPeca());
            System.out.println("-----------------------------------------------------");
            System.out.println("- QTD de Peças Necessárias : "+pecas.getQuantidade());
            System.out.println("-----------------------------------------------------");
            System.out.println("- QTD em Estoque           : "+quantidadePecasEmEstoque);
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            if(quantidadePecasEmEstoque >= pecas.getQuantidade()){
                System.out.println("\u001b[32m✔ Disponivel para executar manutenção!\u001b[0m");
            }else{
                System.out.println("\u001b[31m✖ Indisponivel para executar manutenção!\u001b[0m");
                return;
            }

        }
    }

}
