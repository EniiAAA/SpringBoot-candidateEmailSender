package br.com.vivo.desafio.api.controller;

import br.com.vivo.desafio.api.dto.DadosCandidatos;
import br.com.vivo.desafio.api.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
//anotação usada para api rest
//Para que o Spring reconheça a classe como um Controller
@RequestMapping("candidatos")
//qual é o url que o controller vai responder, quando chegar uma requisição
public class CandidatoController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping
    //chamando requisição Post no insomnia

    public DadosCandidatos cadastrar(@RequestBody @Valid DadosCandidatos dados) {
        System.out.println(dados);
        return dados;
    }

    @PostMapping("/criarcandidato")
    public ResponseEntity<DadosCandidatos> criarCandidato(@RequestBody String json) {
        try {
            DadosCandidatos candidatos = candidateService.criarCandidato(json);
            return ResponseEntity.ok(candidatos);
        } catch (IllegalArgumentException | IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
