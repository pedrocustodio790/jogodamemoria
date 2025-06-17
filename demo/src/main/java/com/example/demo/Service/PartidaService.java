package com.example.demo.Service;

import com.example.demo.DTO.PartidaRequestDTO;
import com.example.demo.DTO.PartidaResponseDTO;
import com.example.demo.Entity.Jogador;
import com.example.demo.Entity.Partida;
import com.example.demo.Repository.JogadorRepository;
import com.example.demo.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    public PartidaResponseDTO criarPartida(PartidaRequestDTO requestDTO) {
        Jogador jogador = jogadorRepository.findById(requestDTO.getIdJogador())
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        Partida partida = new Partida();
        partida.setJogador(jogador);
        partida.setPontuacao(requestDTO.getPontuacao());
        partida.setDuracaoSegundos(requestDTO.getDuracaoSegundos());
        partida = partidaRepository.save(partida);

        PartidaResponseDTO responseDTO = new PartidaResponseDTO();
        responseDTO.setIdPartida(partida.getIdPartida());
        responseDTO.setIdJogador(partida.getJogador().getIdJogador());
        responseDTO.setPontuacao(partida.getPontuacao());
        responseDTO.setDataPartida(partida.getDataPartida());
        responseDTO.setDuracaoSegundos(partida.getDuracaoSegundos());
        return responseDTO;
    }
}