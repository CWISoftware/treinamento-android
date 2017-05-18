package br.com.cwi.cursoandroid.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String NOME_USUARIO_EXTRA = "nomeUsuarioExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void trocarDeTela(View view) {
        //TextView texto = (TextView)view;
        //String textoElemento = texto.getText().toString();
        EditText txtNome = (EditText)findViewById(R.id.txtNome);
        String textoElemento = txtNome.getText().toString();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(NOME_USUARIO_EXTRA, textoElemento);
        startActivity(intent);
    }

}









