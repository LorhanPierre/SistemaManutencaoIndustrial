package weg.manutencaoIndustrial.app;

import weg.manutencaoIndustrial.controller.ManutencaoSystem;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        var manutencaoSystem = new ManutencaoSystem();

        manutencaoSystem.applicattion();

    }
}