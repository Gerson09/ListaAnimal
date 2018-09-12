package com.gerson.appanimais;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gerson.appanimais.dao.CategoriaDAO;
import com.gerson.appanimais.model.Categoria;

public class CategoriaActivity extends AppCompatActivity {

    private EditText etCatAnimal;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        etCatAnimal = (EditText) findViewById(R.id.etCatAnimal);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }

    private void salvar(){
        String nome = etCatAnimal.getText().toString();

        if (nome.isEmpty()){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle(getResources().getString(R.string.txtAtenção));
            alerta.setMessage(getResources().getString(R.string.txtAviso));
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setNeutralButton("OK", null);
            alerta.show();
        }else {
            Categoria cat = new Categoria();
            cat.setNome(nome);
            CategoriaDAO.inserir(this, cat);

            finish();
        }
    }

}
