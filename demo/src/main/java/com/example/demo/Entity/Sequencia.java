package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Sequencias")
public class Sequencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSequencia;

    @ManyToOne
    @JoinColumn(name = "id_partida", nullable = false)
    private Partida partida;

    @Column(nullable = false)
    private String sequencia;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Boolean acerto;
}
