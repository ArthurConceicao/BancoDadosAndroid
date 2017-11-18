package com.example.arthur.bancodadosandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText carroET = null;
    EditText placaET = null;
    EditText anoET = null;
    Button botao = null;
    Button next = null;
    CamadaBanco banco = new CamadaBanco(this, "bancoCarros", 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carroET = (EditText)findViewById(R.id.editText);
        placaET = (EditText)findViewById(R.id.editText2);
        anoET = (EditText)findViewById(R.id.editText3);
        botao = (Button)findViewById(R.id.button);
        next = (Button)findViewById(R.id.button3);
    }

    public void cadastra(View v){
        ContentValues cv = new ContentValues();
        cv.put("nome", carroET.getText().toString());
        cv.put("placa", placaET.getText().toString());
        cv.put("ano", anoET.getText().toString());
        banco.insereCarro(cv);
        Intent intent = new Intent(this, TelaLista.class);
        startActivity(intent);
    }

    public void prox(View v) {
        Intent intent = new Intent(this, TelaLista.class);
        startActivity(intent);
    }
}
