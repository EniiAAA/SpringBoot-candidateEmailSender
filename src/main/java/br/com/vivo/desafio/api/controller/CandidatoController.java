package br.com.vivo.desafio.api.controller;

import br.com.vivo.desafio.api.dto.DadosCandidatos;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
//anotação usada para api rest
//Para que o Spring reconheça a classe como um Controller
@RequestMapping("candidatos")
//qual é o url que o controller vai responder, quando chegar uma requisição
public class CandidatoController {

    @PostMapping
    //chamando requisição Post no insomnia

    public DadosCandidatos cadastrar(@RequestBody @Valid DadosCandidatos dados){
    System.out.println(dados);
    return dados;
    }
}
