package com.example.arthur.bancodadosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaDetalhes extends AppCompatActivity {

    TextView tvNome = null;
    TextView tvPlaca = null;
    TextView tvAno = null;
    Button buttonRemove = null;
    CamadaBanco banco = new CamadaBanco(this, "bancoCarros", 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhes);

        Bundle dados = getIntent().getExtras();

        tvNome = (TextView)findViewById(R.id.textView2);
        tvPlaca = (TextView)findViewById(R.id.textView3);
        tvAno = (TextView)findViewById(R.id.textView4);
        buttonRemove = (Button)findViewById(R.id.button2);

        tvNome.setText(dados.getString("nome"));
        tvPlaca.setText(dados.getString("placa"));
        tvAno.setText(dados.getString("ano"));
    }

    public void trataAcao(View v){
        Toast.makeText(getBaseContext(), "Funfou", Toast.LENGTH_SHORT).show();
        banco.removeCarro(tvPlaca.getText().toString());
        this.finish();
    }
}
