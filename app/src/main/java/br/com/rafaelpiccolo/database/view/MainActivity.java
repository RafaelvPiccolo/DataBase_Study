package br.com.rafaelpiccolo.database.view;

import androidx.appcompat.app.AppCompatActivity;

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
        btnUpdate = findViewById(R.id.btnUpdate);
        txtID = findViewById(R.id.txtID);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);

        cliente = new Cliente();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtName.getText().toString())) {
                    txtName.setError("You must set a name to add to the database");
                } else if (TextUtils.isEmpty(txtEmail.getText().toString())) {
                    txtEmail.setError("You must set a email to add to the database");
                } else {
                    cliente.setNome(txtName.getText().toString());
                    cliente.setEmail(txtEmail.getText().toString());
                    clienteController.incluir(cliente);
                    Toast.makeText(MainActivity.this, "Cliente " + txtName.getText() + " incluido com sucesso",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(txtID.getText().toString())) {
                    txtID.setError("You must set an ID to delete in database");
                } else {
                    int id = Integer.parseInt(txtID.getText().toString());
                    if (clienteController.checkIfExistsIDInDB(id)) {
                        clienteController.deletar(id);
                    } else {
                        txtID.setError("This ID does not exists in database");
                    }
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente obj = new Cliente();
                obj.setNome(txtName.getText().toString());
                obj.setEmail(txtEmail.getText().toString());

                if (TextUtils.isEmpty(txtName.getText().toString())) {
                    txtName.setError("You must set a name to update");
                } else if (TextUtils.isEmpty(txtEmail.getText().toString())) {
                    txtEmail.setError("You must set a email to update");
                } else if (!TextUtils.isEmpty(txtID.getText().toString())) {

                    obj.setId(Integer.parseInt(txtID.getText().toString()));

                    if (clienteController.checkIfExistsIDInDB(obj.getId())) {
                        clienteController.alterar(obj);
                        Toast.makeText(MainActivity.this, "Client " + obj.getNome() + " successfully updated",
                                Toast.LENGTH_LONG).show();
                    } else {
                        txtID.setError("This ID does not exists in database");
                    }
                } else {
                    txtID.setError("You must set a ID to update");
                }
            }
        });
    }
}