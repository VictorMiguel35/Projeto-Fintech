package br.com.fiap.fintech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_transacao")
@Table(name = "tb_fin_transacao")
public abstract class Transacao {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TRANSACOES"
    )
    @SequenceGenerator(
            name = "SEQ_TRANSACOES",
            sequenceName = "SEQ_TRANSACOES",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "data_transacao")
    private LocalDate  dataTransacao;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal valorTransacao;

    private String descricaoTransacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carteira", nullable = false)
    private Carteira carteira;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public BigDecimal getValorTransacao() {return valorTransacao; }
    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    @JsonIgnore
    public Usuario getUsuario() { return usuario; }

    @JsonProperty
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @JsonIgnore
    public Carteira getCarteira() {
        return carteira;
    }

    @JsonProperty
    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @JsonIgnore
    public Categoria getCategoria() {
        return categoria;
    }

    @JsonProperty
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

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

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }
}

