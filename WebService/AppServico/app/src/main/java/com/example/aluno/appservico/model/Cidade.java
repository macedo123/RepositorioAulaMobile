package com.example.aluno.appservico.model;

/**
 * Created by aluno on 30/10/2017.
 */

public class Cidade {
    private int id;
    private String nome,estado;

    public Cidade() {
    }

    public Cidade(int id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public int getId() {
        return id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
