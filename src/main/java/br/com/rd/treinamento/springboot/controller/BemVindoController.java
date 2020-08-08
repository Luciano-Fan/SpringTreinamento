package br.com.rd.treinamento.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BemVindoController {

    @GetMapping("/")
    public String obterBoasVindas(){
        return "Bem-Vindo ao Spring Boot";
    }
}
