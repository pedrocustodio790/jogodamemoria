package com.example.demo.Repository;

import com.example.demo.Entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
