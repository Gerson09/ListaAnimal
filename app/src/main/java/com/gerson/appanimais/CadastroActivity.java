package com.gerson.appanimais;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.gerson.appanimais.dao.AnimalDAO;
import com.gerson.appanimais.dao.CategoriaDAO;
import com.gerson.appanimais.model.Animal;
import com.gerson.appanimais.model.Categoria;

import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNomeAnimal, etIdade;
    private Spinner spCadastro;
    private Button btnSalvarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        etNomeAnimal = (EditText) findViewById(R.id.etNomeAnimal);
        etIdade = (EditText) findViewById(R.id.etIdade);
        spCadastro = (Spinner) findViewById(R.id.spCadastro);
        btnSalvarCadastro = (Button) findViewById(R.id.btnSalvarCadastro);

        carregarCategorias();

        btnSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }

    private void salvar(){
        String nome = etNomeAnimal.getText().toString();

        if (nome.isEmpty() || spCadastro.getSelectedItemPosition() == 0){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle(getResources().getString(R.string.txtAtenção));
            alerta.setMessage(getResources().getString(R.string.txtAviso));
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setNeutralButton("OK", null);
            alerta.show();
        }else{
            String idade = etIdade.getText().toString();
            if (idade.isEmpty())
                idade = "0";
            idade = idade.replace(",",".");
            int IdadeNum = Integer.valueOf(idade);

            Animal animal = new Animal();
            animal.setNome(nome);
            animal.setIdade(IdadeNum);
            animal.setCategoria((Categoria)spCadastro.getSelectedItem());

            AnimalDAO.inserir(this, animal);

            finish();
        }
    }




    private void carregarCategorias(){
        List<Categoria> lista = CategoriaDAO.getCategorias(this);
        Categoria fake = new Categoria();
        fake.setId(0);
        fake.setNome(getResources().getString(R.string.txtSelecione));
        lista.add(0, fake);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        spCadastro.setAdapter(adapter);
    }


}
