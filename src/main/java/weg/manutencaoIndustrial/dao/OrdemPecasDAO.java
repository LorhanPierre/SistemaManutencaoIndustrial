package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.model.OrdemPecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<OrdemPecas> BuscarPecasPorId(int id) throws SQLException{

        List<OrdemPecas> listOrdemPecas = new ArrayList<>();

        String query = "SELECT " +
                "idPeca, " +
                "quantidade " +
                "FROM OrdemPeca " +
                "WHERE idOrdem = ? ";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
         stmt.setInt(1,id);

          ResultSet rs = stmt.executeQuery();
          while(rs.next()){
              int idPeca = rs.getInt("idPeca");
              double quantidade = rs.getDouble("quantidade");
              var ordem = new OrdemPecas(idPeca,quantidade);
              listOrdemPecas.add(ordem);
          }
        }
        return listOrdemPecas;
    }
}
