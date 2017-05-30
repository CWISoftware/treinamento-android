package br.com.cwi.cursoandroid.locadoraroots.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cwi.cursoandroid.locadoraroots.R;
import br.com.cwi.cursoandroid.locadoraroots.models.JogoSnes;

public class JogoSnesAdapter extends BaseAdapter {

    private List<JogoSnes> jogos;
    private Context context;
    private LayoutInflater inflater;

    public JogoSnesAdapter(Context context, List<JogoSnes> jogos) {
        this.context = context;
        this.jogos = jogos;
        // https://developer.android.com/reference/android/view/LayoutInflater.html
        //this.inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return this.jogos.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //@Override
    public JogoSnes getItem(int position) {
        return this.jogos.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //JogoSnes jogo = (JogoSnes)this.getItem(position);
        JogoSnes jogo = this.getItem(position);
        View view = this.inflater.inflate(R.layout.jogosnes_list_item, parent, false);
        int width = view.getWidth();
        TextView lblTitulo = (TextView)view.findViewById(R.id.lblTitulo);
        lblTitulo.setText(jogo.titulo);
        TextView lblAno = (TextView)view.findViewById(R.id.lblAno);
        lblAno.setText(String.valueOf(jogo.anoLancamento));
        return view;
    }
}









