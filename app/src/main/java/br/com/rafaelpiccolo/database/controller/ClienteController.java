package br.com.rafaelpiccolo.database.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelpiccolo.database.api.AppUtil;
import br.com.rafaelpiccolo.database.datamodel.ClienteDataModel;
import br.com.rafaelpiccolo.database.datasource.AppDataBase;
import br.com.rafaelpiccolo.database.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObj;

    public ClienteController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoDoObj = new ContentValues();
        dadoDoObj.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObj.put(ClienteDataModel.EMAIL, obj.getEmail());
        return insert(ClienteDataModel.TABELA, dadoDoObj);
    }

    @Override
    public boolean deletar(int id) {
        return deleteByID(ClienteDataModel.TABELA, id);
    }

    @Override
    public boolean alterar(Cliente obj) {

         dadoDoObj = new ContentValues();

         dadoDoObj.put(ClienteDataModel.ID, obj.getId());
         dadoDoObj.put(ClienteDataModel.NOME, obj.getNome());
         dadoDoObj.put(ClienteDataModel.EMAIL, obj.getEmail());
         return update(ClienteDataModel.TABELA, dadoDoObj);
    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes(ClienteDataModel.TABELA);
    }

    public boolean checkIfExistsIDInDB(int id){
        return CheckifExistsIDInDB(ClienteDataModel.TABELA, id);
    }
}
