package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Carteira;
import br.com.fiap.fintech.service.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carteira salvar(@RequestBody Carteira carteira) {
        return carteiraService.salvar(carteira);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Carteira buscarPorId(@PathVariable Long id) {
        return carteiraService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Carteira> buscarTodos() {
        return carteiraService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        carteiraService.excluir(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Carteira atualizar(@PathVariable Long id, @RequestBody Carteira carteira) {
        return  carteiraService.atualizar(id, carteira);
    }
}
