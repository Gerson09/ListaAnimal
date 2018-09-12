package com.gerson.appanimais.model;

/**
 * Created by android on 12/09/2018.
 */

public class Categoria {
    private int id;
    private String nome;

    public Categoria(){

    }

    public Categoria(String nome) {
        this.nome = nome;

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
