package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Partidas")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartida;

    @ManyToOne
    @JoinColumn(name = "id_jogador", nullable = false)
    private Jogador jogador;

    @Column(nullable = false)
    private Integer pontuacao;

    @Column(name = "data_partida", nullable = false)
    private LocalDateTime dataPartida = LocalDateTime.now();

    private Integer duracaoSegundos;
}
