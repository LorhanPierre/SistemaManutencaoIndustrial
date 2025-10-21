package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.model.Tecnicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Tecnicos> listarTecnicos() throws SQLException{
        List<Tecnicos> tecnicos = new ArrayList<>();

        String query = "SELECT " +
                "id, " +
                "nome, " +
                "especialidade " +
                "FROM Tecnico";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Tecnicos tecnico = new Tecnicos();
                tecnico.setIdTecnico(rs.getInt("id"));
                tecnico.setNomeTecnico(rs.getString("nome"));
                tecnico.setEspecialidadeTecnico(rs.getString("especialidade"));
                tecnicos.add(tecnico);
            }
        }
        return tecnicos;
    }

    public boolean validarIdTecnico(int idTecnico) throws SQLException{

        String query = "SELECT id FROM Tecnico WHERE id = ?";
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, idTecnico);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
}
