package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.model.OrdemPecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdemPecasDAO {

    public void CriarOrdemPecas(OrdemPecas pecas) throws SQLException{

        String query = "INSERT INTO OrdemPeca (idOrdem, idPeca,quantidade) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1,pecas.getIdOrdem());
            stmt.setInt(2,pecas.getIdPeca());
            stmt.setDouble(3,pecas.getQuantidade());
            stmt.executeUpdate();

        }
    }
}
