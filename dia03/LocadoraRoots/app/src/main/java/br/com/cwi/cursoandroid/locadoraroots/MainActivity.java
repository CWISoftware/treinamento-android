package br.com.cwi.cursoandroid.locadoraroots;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import br.com.cwi.cursoandroid.locadoraroots.adapters.JogoSnesAdapter;
import br.com.cwi.cursoandroid.locadoraroots.models.JogoSnes;
import br.com.cwi.cursoandroid.locadoraroots.models.ListaJogosSnes;
import br.com.cwi.cursoandroid.locadoraroots.utils.Constantes;

public class MainActivity extends AppCompatActivity {

    private ListView lstJogos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolBarMain);
        setSupportActionBar(myToolbar);
        lstJogos = (ListView)findViewById(R.id.lstJogos);
        final Context context = this;
        final JogoSnesAdapter adapterJogos = new JogoSnesAdapter(this, ListaJogosSnes.getAll());
        lstJogos.setLongClickable(true);
        lstJogos.setAdapter(adapterJogos);
        lstJogos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListaJogosSnes.remover(position);
                adapterJogos.notifyDataSetChanged();
                return false;
            }
        });
        lstJogos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, DetalheJogoSnesActivity.class);
                JogoSnes jogoTocado = adapterJogos.getItem(position);
                intent.putExtra(Constantes.USUARIO_DETALHE, jogoTocado);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemBusca:
                // https://developer.android.com/reference/android/support/design/widget/Snackbar.html
                Toast.makeText(this, "TODO: pesquisar", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}











