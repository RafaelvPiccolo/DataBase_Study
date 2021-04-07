package br.com.rafaelpiccolo.database.model;

import android.util.Log;

import br.com.rafaelpiccolo.database.api.AppUtil;
import br.com.rafaelpiccolo.database.controller.ICrud;

public class Cliente{

    private int id; // Chave Primária Data Base
    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
