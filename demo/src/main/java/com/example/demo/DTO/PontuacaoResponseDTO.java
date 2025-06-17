package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PontuacaoResponseDTO {
    private String nome;
    private Integer pontuacao;
    private LocalDateTime dataPartida;
}
