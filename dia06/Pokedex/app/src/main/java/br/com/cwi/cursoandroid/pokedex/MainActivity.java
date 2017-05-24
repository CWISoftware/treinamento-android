package br.com.cwi.cursoandroid.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import br.com.cwi.cursoandroid.pokedex.asynctasks.GetPokemonAsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetPokemonAsyncTask(this).execute(56);
    }

    public void renderizarNome(String nomePokemon) {
        Toast.makeText(this, nomePokemon, Toast.LENGTH_LONG).show();
    }
}
