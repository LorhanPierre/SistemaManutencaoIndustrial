package weg.manutencaoIndustrial.dao;

import weg.manutencaoIndustrial.connection.Conexao;
import weg.manutencaoIndustrial.dto.ValidacaoMaquina;
import weg.manutencaoIndustrial.model.Maquinas;
import weg.manutencaoIndustrial.model.enums.StatusMaquinas;
import weg.manutencaoIndustrial.model.enums.StatusOrdemManutencao;

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

    public List<Maquinas> ListarMaquinasEmOperacao() throws SQLException{
        List<Maquinas> maquinas = new ArrayList<>();

        String tipo = StatusMaquinas.OPERACIONAL.toString();

        String query = "SELECT " +
                "id, " +
                "nome, " +
                "setor " +
                "FROM Maquina " +
                "WHERE status = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, tipo);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String setor = rs.getString("setor");
                var maquina = new Maquinas(id,nome,setor,null);
                maquinas.add(maquina);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return maquinas;
    }

    public void alterarStatusMaquinas(int id) throws SQLException{

        String query = "UPDATE Maquina SET status = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, String.valueOf(StatusMaquinas.EM_MANUTENCAO));
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public boolean validarIdMaquinas(int id) throws SQLException{

        String query = "SELECT id FROM Maquina WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return  rs.next();
        }
    }
}
