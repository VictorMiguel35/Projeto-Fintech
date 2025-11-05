package br.com.fiap.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Receita  extends  Transacao {

    @Column(name = "fonte_pagadora", length = 100)
    private String fontePagadora;

    public String getFontePagadora() {
        return fontePagadora;
    }

    public void setFontePagadora(String fontePagadora) {
        this.fontePagadora = fontePagadora;
    }
}
