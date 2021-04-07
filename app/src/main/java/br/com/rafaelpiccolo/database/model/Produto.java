package br.com.rafaelpiccolo.database.model;

import android.util.Log;

import br.com.rafaelpiccolo.database.api.AppUtil;
import br.com.rafaelpiccolo.database.controller.ICrud;

public class Produto{

    private int id;
    private String nomeDoProduto;
    private String fornecedor;

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getId(){return id; }

    public void setId(int id){this.id = id;}
}
