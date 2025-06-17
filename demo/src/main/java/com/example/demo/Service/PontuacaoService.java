package com.example.demo.Service;

import com.example.demo.DTO.PontuacaoResponseDTO;
import com.example.demo.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontuacaoService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<PontuacaoResponseDTO> obterPontuacoes() {
        return partidaRepository.findAll().stream()
                .map(partida -> {
                    PontuacaoResponseDTO dto = new PontuacaoResponseDTO();
                    dto.setNome(partida.getJogador().getNome());
                    dto.setPontuacao(partida.getPontuacao());
                    dto.setDataPartida(partida.getDataPartida());
                    return dto;
                })
                .sorted((a, b) -> b.getPontuacao().compareTo(a.getPontuacao()))
                .limit(10)
                .collect(Collectors.toList());
    }
}