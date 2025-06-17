package com.example.demo.Service;

import com.example.demo.DTO.JogadorRequestDTO;
import com.example.demo.DTO.JogadorResponseDTO;
import com.example.demo.Entity.Jogador;
import com.example.demo.Repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public JogadorResponseDTO criarJogador(JogadorRequestDTO requestDTO) {
        Jogador jogador = new Jogador();
        jogador.setNome(requestDTO.getNome());
        jogador = jogadorRepository.save(jogador);

        JogadorResponseDTO responseDTO = new JogadorResponseDTO();
        responseDTO.setIdJogador(jogador.getIdJogador());
        responseDTO.setNome(jogador.getNome());
        responseDTO.setDataCriacao(jogador.getDataCriacao());
        return responseDTO;
    }
}
