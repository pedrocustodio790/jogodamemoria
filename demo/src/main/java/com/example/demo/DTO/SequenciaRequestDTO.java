package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SequenciaRequestDTO {
    private Long idPartida;
    private String sequencia;
    private Integer nivel;
    private Boolean acerto;
}
