package br.com.rafaelpiccolo.database.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import br.com.rafaelpiccolo.database.api.AppUtil;
import br.com.rafaelpiccolo.database.datamodel.ClienteDataModel;
import br.com.rafaelpiccolo.database.model.Cliente;


public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppMinhaIdeia.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Bados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: Tabela Cliente criada..."+ClienteDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean insert(String tabela, ContentValues dados){

        db = getWritableDatabase();

        boolean retorno = false;

        try{

            retorno = db.insert(tabela, null, dados) > 0;

        }catch(Exception e){

            Log.d(AppUtil.TAG, "AppDataBase: Insert "+e.getMessage());

        }

        return retorno;
    }

    public boolean deleteByID(String tabela, int id){

        db = getWritableDatabase();

        boolean retorno = false;

        try{

            retorno  = db.delete(tabela,"id = ?",new String[] {String.valueOf(id)}) > 0;

        }catch(Exception e){

            Log.e(AppUtil.TAG, "delete: "+ e.getMessage());

        }
        return retorno;
    }

    public boolean update(String tabela, ContentValues dados){

        db = getWritableDatabase();

        boolean retorno = false;

        try{

            retorno = db.update(tabela,dados,"id=?",new String[] {String.valueOf(dados.get("id"))}) > 0;

        }catch(Exception e){

            Log.d(AppUtil.TAG, "AppDataBase: Update "+e.getMessage());

        }

        return retorno;
    }

    public List<Cliente> getAllClientes(String tabela){

        db = getWritableDatabase();

        Cliente obj;

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM "+tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));

                clientes.add(obj);

                Log.i("Listar", "getAllClientes: "+obj.getNome());
            }while(cursor.moveToNext());
        }

        return clientes;

    }

    public boolean CheckifExistsIDInDB(String tabela, Integer id){
        boolean retorno = false;

        db = getWritableDatabase();

        Cliente obj;

        String sql = "SELECT * FROM "+tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                if(obj.getId() == id){
                    retorno = true;
                }
            }while(cursor.moveToNext());

        }

        return retorno;
    }
}
