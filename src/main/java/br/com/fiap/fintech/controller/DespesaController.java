package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Despesa salvar(@RequestBody Despesa despesa) {
        return transacaoService.salvarDespesa(despesa);
    }
}