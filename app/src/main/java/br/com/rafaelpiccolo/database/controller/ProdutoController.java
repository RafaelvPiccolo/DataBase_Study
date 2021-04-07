package br.com.rafaelpiccolo.database.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelpiccolo.database.datamodel.ProdutoDataModel;
import br.com.rafaelpiccolo.database.datasource.AppDataBase;
import br.com.rafaelpiccolo.database.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObj;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Produto obj) {
        dadoDoObj = new ContentValues();
        dadoDoObj.put(ProdutoDataModel.NOME, obj.getNomeDoProduto());
        dadoDoObj.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());
        return insert(ProdutoDataModel.TABELA, dadoDoObj);
    }

    @Override
    public boolean deletar(int id) {
        return deleteByID(ProdutoDataModel.TABELA, id);
    }

    @Override
    public boolean alterar(Produto obj) {

        dadoDoObj = new ContentValues();

        dadoDoObj.put(ProdutoDataModel.ID, obj.getId());
        dadoDoObj.put(ProdutoDataModel.NOME, obj.getNomeDoProduto());
        dadoDoObj.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return true;
    }

    @Override
    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();

        return lista;
    }
}
