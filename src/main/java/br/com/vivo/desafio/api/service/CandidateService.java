package br.com.vivo.desafio.api.service;


import br.com.vivo.desafio.api.dto.DadosCandidatos;
import br.com.vivo.desafio.api.dto.SkillsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class CandidateService {
    public DadosCandidatos criarCandidato(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DadosCandidatos candidatos = objectMapper.readValue(json, DadosCandidatos.class);

        for (SkillsDTO skills : candidatos.getHabilidade()) {
            if (skills.getPontuacao() < 0 || skills.getPontuacao() > 10) {
                throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
            }
        }

        return candidatos;
    }

}
