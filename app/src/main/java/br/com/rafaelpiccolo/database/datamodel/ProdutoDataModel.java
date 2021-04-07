package br.com.rafaelpiccolo.database.datamodel;

public class ProdutoDataModel {
    public static final String TABELA = "produto";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String FORNECEDOR = "fornecedor";

    public static String queryCriaTabela = "";

    public static String criarTabela() {

        queryCriaTabela+= "CREATE TABLE "+TABELA+" (";
        queryCriaTabela+= ID+" integer primary key autoincrement, ";
        queryCriaTabela+= NOME+" text, ";
        queryCriaTabela+= FORNECEDOR+" text ";
        queryCriaTabela+= ")";

        return queryCriaTabela;
    }
}
