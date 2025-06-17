package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SequenciaResponseDTO {
    private Long idSequencia;
    private Long idPartida;
    private String sequencia;
    private Integer nivel;
    private Boolean acerto;
}
