package com.example.arthur.bancodadosandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.arthur.bancodadosandroid.R.id.parent;

public class TelaLista extends AppCompatActivity {

    ListView listView = null;
    ArrayList<Carro> carros;
    ArrayList<String> consulta;
    CamadaBanco banco = new CamadaBanco(this, "bancoCarros", 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista);

        consulta = banco.listaCarros();
        carros = new ArrayList<>();

        for (String item : consulta) {
            String[] itens = item.split(" ");
            Carro carro = new Carro();
            carro.setNome(itens[0]);
            carro.setPlaca(itens[1]);
            carro.setAno(itens[2]);
            carros.add(carro);
        }

        Adaptador adaptador = new Adaptador(carros, this);

        listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Carro itemCarro = (Carro) adapterView.getItemAtPosition(i);
                Bundle dados = new Bundle();
                dados.putString("nome", itemCarro.getNome());
                dados.putString("placa", itemCarro.getPlaca());
                dados.putString("ano", itemCarro.getAno());
                Intent intent = new Intent(TelaLista.this, TelaDetalhes.class);
                intent.putExtras(dados);
                startActivity(intent);
            }
        });
    }

}

