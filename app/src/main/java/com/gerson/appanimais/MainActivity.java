package com.gerson.appanimais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLista, btnCadastrar, btnCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLista = (Button)findViewById(R.id.btnLista);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCategoria = (Button) findViewById(R.id.btnCategoria);

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, ListaActivity.class);
                startActivity(I);
            }

        });

        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent( MainActivity.this, CategoriaActivity.class);
                startActivity(I);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this,CadastroActivity.class);
                startActivity(I);
            }
        });
    }
}
