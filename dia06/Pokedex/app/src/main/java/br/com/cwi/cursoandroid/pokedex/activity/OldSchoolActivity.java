package br.com.cwi.cursoandroid.pokedex.activity;

import android.os.Bundle;

import br.com.cwi.cursoandroid.pokedex.R;
import br.com.cwi.cursoandroid.pokedex.async.OldSchoolGetPokemonAsyncTask;

public class OldSchoolActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oldschool);
        new OldSchoolGetPokemonAsyncTask(this).execute(56);
    }

    public void renderizarNome(String nomePokemon) {
        showLongToast(nomePokemon);
    }
}
