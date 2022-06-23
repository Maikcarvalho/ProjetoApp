package br.com.senac.projetoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostrarFilmesActivity extends AppCompatActivity {
    //Declarando as variáveis globais
    ImageView imgFilmes;
    TextView txtTitulo,txtAno,txtClassificacao,txtNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_filmes_layout);

        imgFilmes = findViewById(R.id.imgMostrarFilmes);
        txtTitulo = findViewById(R.id.txtModeloTitulo);
        txtAno = findViewById(R.id.txtAnoMostraFilmes);
        txtClassificacao = findViewById(R.id.txtClassificacaoMostrarFilmes);
        txtNotas = findViewById(R.id.txtNotaMostrarFilmes);

        Intent intent = getIntent();

        String titulo = intent.getStringExtra("titulo");
        String ano = intent.getStringExtra("ano");
        String classificacao = intent.getStringExtra("classificacao");
        String nota = intent.getStringExtra("nota");
        int imagem = intent.getIntExtra("imagemFilme",0);

        txtTitulo.setText(titulo);
        txtAno.setText(ano);
        txtClassificacao.setText(classificacao);
        txtNotas.setText(nota);
        imgFilmes.setImageResource(imagem);
    }
}