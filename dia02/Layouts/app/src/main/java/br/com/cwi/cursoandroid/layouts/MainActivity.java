package br.com.cwi.cursoandroid.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int SUECIA = R.string.skal;
    private final int BELGICA = R.string.bons_chocolates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viajar(View view) {
        TextView elementoTocado = (TextView)view;
        String texto = elementoTocado.getText().toString();
        Intent intent = null;

        if (texto.equals(getResources().getString(SUECIA))) {
            intent = new Intent(this, SwedenActivity.class);
        } else if (texto.equals(getResources().getString(BELGICA))) {
            intent = new Intent(this, BelgiumActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
