package br.com.cwi.cursoandroid.locadoraroots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.cwi.cursoandroid.locadoraroots.models.JogoSnes;
import br.com.cwi.cursoandroid.locadoraroots.utils.Constantes;

public class DetalheJogoSnesActivity extends AppCompatActivity {

    private JogoSnes jogo;
    private TextView lblTitulo, lblTipo, lblAnoLancamento;
    private ImageView imgCapaJogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_jogo_snes);
        initComponents();
        loadData();

    }

    private void loadData() {
        this.jogo = (JogoSnes)getIntent().getSerializableExtra(Constantes.USUARIO_DETALHE);
        setTitle(this.jogo.getTitulo());
        this.lblTitulo.setText(this.jogo.getTitulo());
        this.lblTipo.setText(this.jogo.getTipo());
        //this.lblAnoLancamento.setText(String.valueOf(this.jogo.getAnoLancamento()));
        this.lblAnoLancamento.setText(this.jogo.getAnoLancamento().toString());
        Picasso.with(this)
                .load(this.jogo.getUrlCapaJogo())
                .into(this.imgCapaJogo);
    }

    private void initComponents() {
        this.lblTitulo = (TextView)findViewById(R.id.lblTitulo);
        this.lblTipo = (TextView)findViewById(R.id.lblTipo);
        this.lblAnoLancamento = (TextView)findViewById(R.id.lblAnoLancamento);
        this.imgCapaJogo = (ImageView)findViewById(R.id.imgCapaJogo);
    }
}
