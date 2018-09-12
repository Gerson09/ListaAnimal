package com.gerson.appanimais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gerson.appanimais.model.Animal;
import com.gerson.appanimais.model.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 12/09/2018.
 */

public class AnimalDAO {
    public static void inserir(Context contexto, Animal animal) {
        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", animal.getNome());
        values.put("idade", animal.getIdade());
        values.put("codCategoria", animal.getCategoria().getId());

        banco.insert("animais", null, values);
    }

    public static List<Animal> getAnimais(Context contexto) {
        List<Animal> listaDeAnimais = new ArrayList<>();
        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getReadableDatabase();

        Cursor tabela = banco.rawQuery("SELECT * FROM animais", null);
        if (tabela.getCount() > 0) {
            tabela.moveToFirst();

            do {
                Categoria cat = new Categoria();
                cat.setId(tabela.getInt(3));

                Animal animal = new Animal();
                animal.setId(tabela.getInt(0));
                animal.setNome(tabela.getString(1));
                animal.setIdade(tabela.getInt(2));
                animal.setCategoria(cat);

                listaDeAnimais.add(animal);
            } while (tabela.moveToNext());
        }

        return listaDeAnimais;
    }
}
