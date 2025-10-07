package weg.manutencaoIndustrial.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/ManutencaoSystem?useSSL=false&amp;serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "mysqlPW";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

/*-- Tabela de Máquinas
CREATE TABLE Maquina (
        id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
setor VARCHAR(50) NOT NULL,
status VARCHAR(20) NOT NULL -- OPERACIONAL / EM_MANUTENCAO
);
        -- Tabela de Técnicos
CREATE TABLE Tecnico (
        id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
especialidade VARCHAR(50)
);
        -- Tabela de Peças
CREATE TABLE Peca (
        id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
estoque DOUBLE NOT NULL
);
        -- Tabela de Ordens de Manutenção
CREATE TABLE OrdemManutencao (
        id INT PRIMARY KEY AUTO_INCREMENT,

        idMaquina INT NOT NULL,
        idTecnico INT NOT NULL,
        dataSolicitacao DATE NOT NULL,
        status VARCHAR(20) NOT NULL, -- PENDENTE / EXECUTADA / CANCELADA
FOREIGN KEY (idMaquina) REFERENCES Maquina(id),
FOREIGN KEY (idTecnico) REFERENCES Tecnico(id)
        );
        -- Tabela de Peças utilizadas em cada ordem
CREATE TABLE OrdemPeca (
        idOrdem INT NOT NULL,
        idPeca INT NOT NULL,
        quantidade DOUBLE NOT NULL,
        PRIMARY KEY (idOrdem, idPeca),
FOREIGN KEY (idOrdem) REFERENCES OrdemManutencao(id),
FOREIGN KEY (idPeca) REFERENCES Peca(id)
        );*/