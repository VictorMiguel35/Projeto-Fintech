package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receita salvar(@RequestBody Receita receita) {
        return transacaoService.salvarReceita(receita);
    }
}