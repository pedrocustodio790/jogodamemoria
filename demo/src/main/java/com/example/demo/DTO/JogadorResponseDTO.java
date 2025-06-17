package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorResponseDTO {
    private Long idJogador;
    private String nome;
    private LocalDateTime dataCriacao;
}
