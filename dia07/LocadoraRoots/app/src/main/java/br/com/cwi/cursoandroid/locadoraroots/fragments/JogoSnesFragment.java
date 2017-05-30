package br.com.cwi.cursoandroid.locadoraroots.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.cwi.cursoandroid.locadoraroots.R;
import br.com.cwi.cursoandroid.locadoraroots.models.JogoSnes;

public class JogoSnesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jogo_snes, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        this.jogo = (JogoSnes)context.getIntent().getSerializableExtra(Constantes.USUARIO_DETALHE);
//        setTitle(this.jogo.getTitulo());
//        this.lblTitulo.setText(this.jogo.getTitulo());
//        this.lblTipo.setText(this.jogo.getTipo());
//        //this.lblAnoLancamento.setText(String.valueOf(this.jogo.getAnoLancamento()));
//        this.lblAnoLancamento.setText(this.jogo.getAnoLancamento().toString());
//        Picasso.with(this)
//                .load(this.jogo.getUrlCapaJogo())
//                .into(this.imgCapaJogo);
    }
}
