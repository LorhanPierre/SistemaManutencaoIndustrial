package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.dto.OrdensPendente;
import weg.manutencaoIndustrial.model.OrdensManutencao;
import weg.manutencaoIndustrial.model.enums.StatusOrdemManutencao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdensManutencaoDAO {

    public void CriarOrdensManutencao(int idMaquina, int idTecnico, OrdensManutencao ordem)throws SQLException{

        String query = "INSERT INTO OrdemManutencao (idMaquina, idTecnico, dataSolicitacao, status) VALUES (?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, idMaquina);
            stmt.setInt(2, idTecnico);
            stmt.setObject(3, LocalDate.now());
            stmt.setString(4, String.valueOf(ordem.getStatusOrdemManutencao(StatusOrdemManutencao.PENDENTE)));
            stmt.executeUpdate();
        }
    }

    public List<OrdensPendente> ListarOrdensPendente() throws SQLException{

        List<OrdensPendente> ordensPendente = new ArrayList<>();

        String query = "SELECT " +
                "id, " +
                "idMaquina, " +
                "idTecnico, " +
                "dataSolicitacao " +
                "FROM OrdemManutencao " +
                "WHERE status = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, String.valueOf(StatusOrdemManutencao.PENDENTE));

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int idMaquina = rs.getInt("idMaquina");
                int idTecnico = rs.getInt("idTecnico");
                LocalDate dataSolicitacao = rs.getObject("dataSolicitacao", LocalDate.class);
                var ordem = new OrdensPendente(id,idMaquina,idTecnico,dataSolicitacao);
                ordensPendente.add(ordem);
            }
        }
        return ordensPendente;
    }

    public boolean validaIdOrdem(int id) throws SQLException{

        String query = "SELECT" +
                " id " +
                "FROM " +
                "OrdemManutencao " +
                "WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                return  rs.next();
            }
        }
    }
}
