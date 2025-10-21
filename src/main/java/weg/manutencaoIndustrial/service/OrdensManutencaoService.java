package weg.manutencaoIndustrial.service;

import weg.manutencaoIndustrial.dao.MaquinasDAO;
import weg.manutencaoIndustrial.dao.OrdensManutencaoDAO;
import weg.manutencaoIndustrial.dao.TecnicosDAO;
import weg.manutencaoIndustrial.model.Maquinas;
import weg.manutencaoIndustrial.model.OrdensManutencao;
import weg.manutencaoIndustrial.model.Tecnicos;
import weg.manutencaoIndustrial.model.enums.StatusOrdemManutencao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static weg.manutencaoIndustrial.utils.Utils.inputNumber;

public class OrdensManutencaoService {

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
            idMaquina = inputNumber();
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
            idTecnico = inputNumber();
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
}
