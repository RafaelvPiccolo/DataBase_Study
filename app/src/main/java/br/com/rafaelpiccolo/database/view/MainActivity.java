package br.com.rafaelpiccolo.database.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafaelpiccolo.database.R;
import br.com.rafaelpiccolo.database.controller.ClienteController;
import br.com.rafaelpiccolo.database.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente cliente;
    Button btnAdd, btnDelete, btnUpdate;
    EditText txtName, txtEmail, txtID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteController = new ClienteController(getApplicationContext());
        btnAdd = findViewById(R.id.btnConfirm);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUptade);
        txtID = findViewById(R.id.txtID);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);

        cliente = new Cliente();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtName.getText().toString())) {
                    txtName.setError("This field cannot be empty");
                } else if (TextUtils.isEmpty(txtEmail.getText().toString())) {
                    txtEmail.setError("This field cannot be empty");
                } else {
                    cliente.setNome(txtName.getText().toString());
                    cliente.setEmail(txtEmail.getText().toString());
                    clienteController.incluir(cliente);
                    Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " incluido com sucesso",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(txtID.getText().toString());

                if (TextUtils.isEmpty(txtID.getText().toString())) {
                    txtID.setError("This field cannot be empty");
                } else if (clienteController.checkIfExistsInDB(id)) {
                    clienteController.deletar(id);
                } else {
                    Toast.makeText(MainActivity.this, "This ID does not exists in database",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

//        for (Cliente obj : clienteController.listar()) {
//            Log.e("retorno", "onCreate: " + obj.getId() + " " + obj.getNome() + " " + obj.getEmail());
//        }
//
//        if (clienteController.deletar(cliente.getId())) {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " removido com sucesso",
//                    Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " não removido com sucesso",
//                    Toast.LENGTH_SHORT).show();
//        }
//
//        if (clienteController.alterar(cliente)) {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " alterado com sucesso",
//                    Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(MainActivity.this, "Cliente " + cliente.getNome() + " não alterado com sucesso",
//                    Toast.LENGTH_SHORT).show();
//        }
    }
}