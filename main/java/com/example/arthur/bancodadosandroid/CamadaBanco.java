package com.example.arthur.bancodadosandroid;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentSender;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Arthur on 16/11/2017.
 */

public class CamadaBanco extends SQLiteOpenHelper {

    String[] scriptCriaBanco =
            {"create table carro (_id integer primary key autoincrement, nome text not null, placa text not null, ano text not null);"};

    public final String scriptApagaBD = "DROP TABLE IF EXISTS carro";

    Context vrContexto = null;

    CamadaBanco(Context contexto, String nome, int versao){
        super(contexto, nome, null, versao);
        vrContexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int iIndex = 0; iIndex < scriptCriaBanco.length; iIndex++){
            db.execSQL(scriptCriaBanco[iIndex]);
        }
    }

    //CRIACAO
    public void insereCarro(ContentValues dados){
        SQLiteDatabase bancoDados = this.getWritableDatabase();

        bancoDados.insert("carro", null, dados);

        Toast.makeText(vrContexto, "Insercao realizada", Toast.LENGTH_SHORT).show();
    }

    //REMOÇÃO
    public void removeCarro(String placa){
        SQLiteDatabase bancoDados = this.getWritableDatabase();

        bancoDados.delete("carro", "placa=", new String[]{placa});

        Toast.makeText(vrContexto, "Remocao realizada", Toast.LENGTH_SHORT).show();
    }

    //CONSULTA
    public ArrayList<String> listaCarros(){
        ArrayList<String> lista = new ArrayList<String>();
        SQLiteDatabase bancoDados = this.getReadableDatabase();
        Cursor cursor = bancoDados.query("carro", new String[]{"nome", "placa", "ano"},
                null, null, null, null, null);

        while(cursor.moveToNext()){
            lista.add(cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2));
        }
        return lista;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptApagaBD);
    }
}
