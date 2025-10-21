package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.model.OrdensManutencao;
import weg.manutencaoIndustrial.model.enums.StatusOrdemManutencao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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
}
