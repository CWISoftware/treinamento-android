package br.com.cwi.cursoandroid.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class RelativeActivity extends AppCompatActivity {

    private List<String> credenciais = Arrays.asList(
            "bernardobrezende@gmail.com:bacon",
            "php@cwi.com.br:css"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
    }
}
