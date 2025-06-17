package com.example.demo.Service;

import com.example.demo.DTO.SequenciaRequestDTO;
import com.example.demo.DTO.SequenciaResponseDTO;
import com.example.demo.Entity.Partida;
import com.example.demo.Entity.Sequencia;
import com.example.demo.Repository.PartidaRepository;
import com.example.demo.Repository.SequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenciaService {

    @Autowired
    private SequenciaRepository sequenciaRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    public SequenciaResponseDTO criarSequencia(SequenciaRequestDTO requestDTO) {
        Partida partida = partidaRepository.findById(requestDTO.getIdPartida())
                .orElseThrow(() -> new RuntimeException("Partida não encontrada"));

        Sequencia sequencia = new Sequencia();
        sequencia.setPartida(partida);
        sequencia.setSequencia(requestDTO.getSequencia());
        sequencia.setNivel(requestDTO.getNivel());
        sequencia.setAcerto(requestDTO.getAcerto());
        sequencia = sequenciaRepository.save(sequencia);

        SequenciaResponseDTO responseDTO = new SequenciaResponseDTO();
        responseDTO.setIdSequencia(sequencia.getIdSequencia());
        responseDTO.setIdPartida(sequencia.getPartida().getIdPartida());
        responseDTO.setSequencia(sequencia.getSequencia());
        responseDTO.setNivel(sequencia.getNivel());
        responseDTO.setAcerto(sequencia.getAcerto());
        return responseDTO;
    }
}