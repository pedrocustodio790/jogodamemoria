package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidaRequestDTO {
    private Long idJogador;
    private Integer pontuacao;
    private Integer duracaoSegundos;
}
