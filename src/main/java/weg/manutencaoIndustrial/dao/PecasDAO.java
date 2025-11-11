package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.model.Pecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Pecas> listarPecas()throws SQLException {

        List<Pecas> listaPecas = new ArrayList<>();

        String query = "SELECT " +
                "id, " +
                "nome, " +
                "estoque " +
                "FROM Peca";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            try (ResultSet rs = stmt.executeQuery()){
                while(rs.next()){

                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int estoque = rs.getInt("estoque");
                    var pecas = new Pecas(id, nome, estoque);
                    listaPecas.add(pecas);
                }
            }
        }
        return listaPecas;
    }

    public boolean validarIdPeca(int idPeca)throws SQLException {

        String query = "SELECT " +
                "id " +
                "FROM " +
                "Peca " +
                "WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, idPeca);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    public int BuscarQuantidadePecas(int idPeca)throws SQLException {

        int estoque = 0;

        String query = "SELECT " +
                "estoque " +
                "FROM Peca " +
                "WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
               stmt.setInt(1, idPeca);
               ResultSet rs = stmt.executeQuery();
               if(rs.next()){
                  estoque = rs.getInt("estoque");
               }
        }
        return estoque;
    }

    public void AtualizarQuantidadePecas(int idPeca,int novoEstoque)throws SQLException {

        String query = "UPDATE Peca SET estoque = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, novoEstoque);
            stmt.setInt(2, idPeca);
            stmt.executeUpdate();
        }
    }
}
