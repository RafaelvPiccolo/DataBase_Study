package br.com.rafaelpiccolo.database.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import br.com.rafaelpiccolo.database.R;
import br.com.rafaelpiccolo.database.api.AppUtil;
import br.com.rafaelpiccolo.database.controller.ClienteController;
import br.com.rafaelpiccolo.database.controller.ProdutoController;
import br.com.rafaelpiccolo.database.model.Cliente;
import br.com.rafaelpiccolo.database.model.Produto;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente cliente;
    
//    ProdutoController produtoController;
//    Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        clienteController = new ClienteController(getApplicationContext());
//        produtoController = new ProdutoController(getApplicationContext());

        for (int i = 0; i < 49 ; i++) {

            cliente = new Cliente();
            cliente.setNome("Cliente"+ i);
            cliente.setEmail("emailgenerico"+i+"@gmail.com");

            clienteController.incluir(cliente);
        }

        for (Cliente obj: clienteController.listar()) {
            Log.e("retorno", "onCreate: "+obj.getId()+" "+obj.getNome()+" "+obj.getEmail());
        }

//        produto = new Produto();
//        produto.setNomeDoProduto("Macbook Air");
//        produto.setFornecedor("Apple");


//        if (clienteController.incluir(cliente)) {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " incluido com sucesso",
//                    Toast.LENGTH_SHORT).show();
//
//            Log.i(AppUtil.TAG, "Cliente " + cliente.getNome() + " Incluido com sucesso");
//        } else {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " não incluido com sucesso",
//                    Toast.LENGTH_SHORT).show();
//            Log.e(AppUtil.TAG, "Cliente " + cliente.getNome() + " não Incluido com sucesso");
//        }
//
//        if (produtoController.incluir(produto)) {
//            Toast.makeText(MainActivity.this, "Produto " + cliente.getNome() + " incluido com sucesso",
//                    Toast.LENGTH_SHORT).show();
//
//            Log.i(AppUtil.TAG, "Produto " + cliente.getNome() + " Incluido com sucesso");
//        } else {
//            Toast.makeText(MainActivity.this, "Produto " + cliente.getNome() + " não incluido com sucesso",
//                    Toast.LENGTH_SHORT).show();
//            Log.e(AppUtil.TAG, "Produto " + cliente.getNome() + " não Incluido com sucesso");
//        }

//        if (clienteController.deletar(cliente.getId())) {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " removido com sucesso",
//                    Toast.LENGTH_SHORT).show();
//
//            Log.i(AppUtil.TAG, "Cliente " + cliente.getNome() + " removido com sucesso");
//        } else {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " não removido com sucesso",
//                    Toast.LENGTH_SHORT).show();
//            Log.e(AppUtil.TAG, "Produto " + cliente.getNome() + " não removido com sucesso");
//        }

//        if (clienteController.alterar(cliente)){
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " alterado com sucesso",
//                    Toast.LENGTH_SHORT).show();
//
//            Log.i(AppUtil.TAG, "Cliente " + cliente.getNome() + " alterado com sucesso");
//        } else {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " não alterado com sucesso",
//                    Toast.LENGTH_SHORT).show();
//            Log.e(AppUtil.TAG, "Produto " + cliente.getNome() + " não alterado com sucesso");
//        }
    }


}