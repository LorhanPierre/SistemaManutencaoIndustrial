package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.model.Pecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PecasDAO {

    public void CadastrarPeca(Pecas peca)throws SQLException {

        String query = "INSERT INTO Peca(nome,estoque) values(?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1,peca.getNomePeca());
            stmt.setDouble(2,peca.getEstoquePeca());
            stmt.executeUpdate();

        }
    }

    public boolean validacaoPeca(String nomePeca)throws SQLException {

        String query = "SELECT " +
                "nome " +
                "FROM " +
                "Peca " +
                "WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, nomePeca);

            try (ResultSet rs = stmt.executeQuery()){
                return  (rs.next());
            }
        }
    }
}
