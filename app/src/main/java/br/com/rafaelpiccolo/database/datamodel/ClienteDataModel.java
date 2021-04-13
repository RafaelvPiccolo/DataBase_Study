package br.com.rafaelpiccolo.database.datamodel;

public class ClienteDataModel {

    public static final String TABELA = "cliente";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";

    public static String queryCriaTabela = "";

    public static String criarTabela() {

        queryCriaTabela+= "CREATE TABLE "+TABELA+" (";
        queryCriaTabela+= ID+" integer primary key autoincrement, ";
        queryCriaTabela+= NOME+" text, ";
        queryCriaTabela+= EMAIL+" text ";
        queryCriaTabela+= ")";

        return queryCriaTabela;
    }
}
