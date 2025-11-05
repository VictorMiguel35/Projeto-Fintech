package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Transacao;
import br.com.fiap.fintech.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transacao buscarPorId(@PathVariable Long id) {
        return transacaoService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Transacao> buscarTodos() {
        return transacaoService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        transacaoService.excluir(id);
    }

    @PatchMapping("/{id}/descricao")
    @ResponseStatus(HttpStatus.OK)
    public Transacao atualizarDescricao(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String novaDescricao = body.get("descricaoTransacao");
        return transacaoService.atualizarDescricao(id, novaDescricao);
    }
}