package br.com.fiap.fintech.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_fin_transacao")
public class Transacao {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TRASACOES"
    )
    @SequenceGenerator(
            name = "SEQ_TRANSACOES",
            sequenceName = "SEQ_TRANSACOES",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "dt_transacao")
    private LocalDate  dataTransacao;

    private double valorTrasacao;
    private String descricaoTransacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public double getValorTrasacao() {
        return valorTrasacao;
    }

    public void setValorTrasacao(double valorTrasacao) {
        this.valorTrasacao = valorTrasacao;
    }

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }
}

