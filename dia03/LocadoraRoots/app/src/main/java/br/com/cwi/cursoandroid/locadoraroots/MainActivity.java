package br.com.cwi.cursoandroid.locadoraroots;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstJogos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        lstJogos = (ListView)findViewById(R.id.lstJogos);
        final List<String> titulos = Arrays.asList(
                "Super Mario Kart",
                "NBA Jam",
                "Mortal Kombat I",
                "Mortal Kombat II",
                "Mortal Kombat III",
                "F-Zero",
                "Battletoads",
                "Mutant Teenage Ninja Turtles",
                "Donkey Kong Country 1",
                "Donkey Kong Country 2",
                "Donkey Kong Country 3",
                "Final Fight",
                "Outro jogo1",
                "Outro jogo2",
                "Outro jogo3",
                "Outro jogo4"
        );
        final ArrayAdapter<String> titulosAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titulos);
        lstJogos.setAdapter(titulosAdapter);
        final Context context = this;
        lstJogos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // String tituloTocado = titulos.get(position);
                String tituloTocado = titulosAdapter.getItem(position);
                Toast.makeText(context, tituloTocado, Toast.LENGTH_LONG).show();
            }
        });
    }
}











