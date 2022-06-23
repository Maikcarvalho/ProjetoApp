package br.com.senac.projetoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declarar as variáveis globais refenciando os componentes
    ListView lstFilmes;

    //Criando os dados para a lista
    String titulo[] = {"After", "Angry Birds 2", "Fast Furious 5", "Hobbit", "Joker",
            "Kung Fu Panda", "Madagascar", "Shrek", "Skyfall", "Turma da Mônica"};
    String ano[] = {"2019", "2019", "2011", "2013", "2019", "2016", "2007", "2001", "2012", "2021"};
    String classificacao[] = {"13 anos ou mais", "7 anos ou mais", "13 anos ou mais",
            "13 anos ou mais", "18 anos ou mais", "7 anos ou mais", "7 anos ou mais",
            "7 anos ou mais", "13 anos ou mais", "7 anos ou mais"};
    int imgFilmes[] = {R.drawable.after, R.drawable.angrybirds, R.drawable.fastfive,
            R.drawable.hobbit, R.drawable.joker, R.drawable.kungfupanda, R.drawable.madagascar,
            R.drawable.shrek, R.drawable.skyfall, R.drawable.turmadamonica};
    String notas[] = {"10", "1.279", "1.966", "7.926", "18.834", "1.593", "1.330", "1.527", "7.461", "11"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstFilmes = findViewById(R.id.listaFilmes);

        //instanciar o adaptador
        MyAdapter adapter = new MyAdapter();

        lstFilmes.setAdapter(adapter);

        lstFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //abrindo outra janela e passando os valores
                Intent intent = new Intent(getApplicationContext(),MostrarFilmesActivity.class);

                intent.putExtra("titulo",titulo[i]);
                intent.putExtra("ano",ano[i]);
                intent.putExtra("classificacao",classificacao[i]);
                intent.putExtra("notas",notas[i]);
                intent.putExtra("imagemFilme",imgFilmes[i]);

                startActivity(intent);
            }
        });
    }

    //criando uma classe interna inner class
    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgFilmes.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //Criando as variáveis globais para os componentes
            ImageView imageFilmes;
            TextView txtTitulo, txtAno, txtClassificacao, txtNotas;

            //Instanciando e carregando o modelo ao adaptador
            View view1 = getLayoutInflater().inflate(R.layout.modelo_filmes,null);

            txtTitulo = view1.findViewById(R.id.txtModeloTitulo);
            txtAno = view1.findViewById(R.id.txtModeloAno);
            txtClassificacao = view1.findViewById(R.id.txtModeloClassificacao);
            txtNotas = view1.findViewById(R.id.txtModeloNotas);
            imageFilmes = view1.findViewById(R.id.imgModeloFilme);

            //Passando os valores para os componentes do modelo
            txtTitulo.setText(titulo[i]);
            txtAno.setText(ano[i]);
            txtClassificacao.setText(classificacao[i]);
            txtNotas.setText(notas[i]);

            imageFilmes.setImageResource(imgFilmes[i]);

            return view1;
        }
    }
}