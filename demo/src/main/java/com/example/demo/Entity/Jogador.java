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
@Table(name = "Jogadores")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogador;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();
}