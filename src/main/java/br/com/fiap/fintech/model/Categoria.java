package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_fin_categoria")
public class Categoria {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CATEGORIAS"
    )
    @SequenceGenerator(
            name = "SEQ_CATEGORIAS",
            sequenceName = "SEQ_CATEGORIAS",
            allocationSize = 1
    )
    private Long id;

    private String nome;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
