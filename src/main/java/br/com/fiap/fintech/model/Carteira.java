package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_fin_carteira")
public class Carteira {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CARTEIRAS"
            )
    @SequenceGenerator(
            name = "SEQ_CARTEIRAS",
            sequenceName = "SEQ_CARTEIRAS",
            allocationSize = 1
    )
    private Long id;

    private double saldo;
    private String nomeCarteira;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeCarteira() {
        return nomeCarteira;
    }

    public void setNomeCarteira(String nomeCarteira) {
        this.nomeCarteira = nomeCarteira;
    }
}
