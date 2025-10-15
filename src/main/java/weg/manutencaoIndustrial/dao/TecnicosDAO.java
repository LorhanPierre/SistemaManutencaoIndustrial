package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.model.Tecnicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TecnicosDAO {

    public void CadastrarTecnico(Tecnicos tecnico)throws SQLException{

        String query = "INSERT INTO Tecnico (nome,especialidade) values (?,?) ";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, tecnico.getNomeTecnico());
            stmt.setString(2, tecnico.getEspecialidadeTecnico());
            stmt.executeUpdate();

        }

    }

    public boolean ValidarTecnico(String nome, String especialidade)throws SQLException {

        String query = "SELECT " +
                "nome, " +
                "especialidade " +
                "FROM Tecnico " +
                "WHERE nome = ? AND especialidade = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, nome);
            stmt.setString(2, especialidade);

            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        }
    }
}
