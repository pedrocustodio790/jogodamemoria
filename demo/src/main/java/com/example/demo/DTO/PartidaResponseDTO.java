package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidaResponseDTO {
    private Long idPartida;
    private Long idJogador;
    private Integer pontuacao;
    private LocalDateTime dataPartida;
    private Integer duracaoSegundos;
}
