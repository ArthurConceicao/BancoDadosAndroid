package com.example.arthur.bancodadosandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Arthur on 19/10/2017.
 */
public class Adaptador extends ArrayAdapter<Carro> {

    Context contexto;

    Adaptador(ArrayList<Carro> lista, Context contexto){
        super(contexto, 0, lista);
        this.contexto = contexto;
    }


    @Override
    public View getView(int posicao, View reciclado, ViewGroup pai) {
        if (reciclado == null){
            //Situação em que não há células disponíveis
            reciclado = LayoutInflater.from(contexto).inflate(R.layout.celula, pai, false);
        }
        Carro copia = getItem(posicao);

        TextView nome = (TextView) reciclado.findViewById(R.id.textView5);
        nome.setText(copia.getNome());

        return reciclado;
    }
}
