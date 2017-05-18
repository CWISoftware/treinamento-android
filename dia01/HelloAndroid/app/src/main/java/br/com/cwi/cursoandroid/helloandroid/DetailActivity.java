package br.com.cwi.cursoandroid.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        //Intent intent2 = getIntent();
        String nomeUsuario = intent.getStringExtra(MainActivity.NOME_USUARIO_EXTRA);
        TextView lblNomeUsuario = (TextView)findViewById(R.id.lblNomeUsuario);
        lblNomeUsuario.setText(nomeUsuario);
    }
}
