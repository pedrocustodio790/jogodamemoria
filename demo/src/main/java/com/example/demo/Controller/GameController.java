package com.example.demo.Controller;

import com.example.demo.DTO.*;
import com.example.demo.Service.JogadorService;
import com.example.demo.Service.PartidaService;
import com.example.demo.Service.PontuacaoService;
import com.example.demo.Service.SequenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class GameController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private PartidaService partidaService;

    @Autowired
    private SequenciaService sequenciaService;

    @Autowired
    private PontuacaoService pontuacaoService;

    @PostMapping("/jogadores")
    public JogadorResponseDTO criarJogador(@RequestBody JogadorRequestDTO requestDTO) {
        return jogadorService.criarJogador(requestDTO);
    }

    @PostMapping("/partidas")
    public PartidaResponseDTO criarPartida(@RequestBody PartidaRequestDTO requestDTO) {
        return partidaService.criarPartida(requestDTO);
    }

    @PostMapping("/sequencias")
    public SequenciaResponseDTO criarSequencia(@RequestBody SequenciaRequestDTO requestDTO) {
        return sequenciaService.criarSequencia(requestDTO);
    }

    @GetMapping("/pontuacoes")
    public List<PontuacaoResponseDTO> obterPontuacoes() {
        return pontuacaoService.obterPontuacoes();
    }
}