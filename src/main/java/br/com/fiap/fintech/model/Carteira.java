package br.com.fiap.fintech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

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

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal saldo;

    private String nomeCarteira;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false) // Chave Estrangeira
    private Usuario usuario;

    public Carteira() {
        this.saldo = BigDecimal.ZERO; // Garante que o saldo nunca seja nulo
    }

    public void creditar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor de crédito deve ser positivo.");
        }
        this.saldo = this.saldo.add(valor);
    }

    public void debitar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor de débito deve ser positivo.");
        }
        if (this.saldo.compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente para esta operação.");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @JsonIgnore
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCarteira() {
        return nomeCarteira;
    }

    public void setNomeCarteira(String nomeCarteira) {
        this.nomeCarteira = nomeCarteira;
    }
}
