package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.dto.ValidacaoMaquina;
import weg.manutencaoIndustrial.model.Maquinas;
import weg.manutencaoIndustrial.model.enums.StatusMaquinas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaquinasDAO {

    public void CadastrarMaquinas(Maquinas maquina) throws SQLException{

        String query = "INSERT INTO Maquina (nome,setor,status) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, maquina.getNomeMaquina());
            stmt.setString(2, maquina.getSetor());
            stmt.setString(3, String.valueOf(maquina.getStatusMaquina(StatusMaquinas.OPERACIONAL)));
            stmt.executeUpdate();
        }
    }

    public boolean validarCriacaoMaquinas(String nome, String setor) throws SQLException{

        String query = "SELECT " +
                "nome," +
                "setor" +
                " FROM Maquina " +
                "where nome = ? and setor = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setString(1, nome);
                stmt.setString(2, setor);

                try (ResultSet rs = stmt.executeQuery()){
                    return  rs.next();
                }
        }
    }
}
