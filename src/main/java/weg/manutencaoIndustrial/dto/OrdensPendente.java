package weg.manutencaoIndustrial.dto;

import java.time.LocalDate;

public record OrdensPendente(int id, int idMaquina, int idTecnico, LocalDate dataSolicitacao) {
}
