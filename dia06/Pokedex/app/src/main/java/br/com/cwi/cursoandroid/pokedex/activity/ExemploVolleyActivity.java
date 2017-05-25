package br.com.cwi.cursoandroid.pokedex.activity;

import android.os.Bundle;

import com.android.volley.VolleyError;

import br.com.cwi.cursoandroid.pokedex.R;
import br.com.cwi.cursoandroid.pokedex.async.PokeApi;
import br.com.cwi.cursoandroid.pokedex.util.CallbackActivity;

public class ExemploVolleyActivity extends BaseActivity
    implements CallbackActivity<String> {

    private PokeApi pokeApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_volley);
        this.pokeApi = new PokeApi(this);
        catchPokemon(134);
    }

    private void catchPokemon(int id) {
        this.pokeApi.fetch(id);
    }

    @Override
    public void onSuccess(String response) {
        showLongToast(response);
    }

    @Override
    public void onError(VolleyError volleyError) {
        showLongToast(volleyError.getMessage());
    }
}
