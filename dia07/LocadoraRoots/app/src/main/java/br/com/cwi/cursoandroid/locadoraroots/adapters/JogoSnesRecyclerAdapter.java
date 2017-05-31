package br.com.cwi.cursoandroid.locadoraroots.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.cursoandroid.locadoraroots.MainActivity;
import br.com.cwi.cursoandroid.locadoraroots.R;
import br.com.cwi.cursoandroid.locadoraroots.models.JogoSnes;

public class JogoSnesRecyclerAdapter extends RecyclerView.Adapter<JogoSnesRecyclerAdapter.ViewHolder> {

    private List<JogoSnes> jogos;
    private Double descontoJogos;
    private String tipoDescontoJogos;

    public JogoSnesRecyclerAdapter(String tipoDescontoJogos, Double descontoJogos) {
        this.tipoDescontoJogos = tipoDescontoJogos;
        this.descontoJogos = descontoJogos;
        this.jogos = new ArrayList<JogoSnes>();
    }

    // 1. 3 métodos da classe RecyclerView.Adapter
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.jogosnes_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JogoSnes jogo = this.jogos.get(position);
        holder.lblTitulo.setText(jogo.titulo);
        holder.lblAno.setText(jogo.anoLancamento.toString());
        Picasso.with(holder.context)
                .load(jogo.urlCapaJogo)
                .into(holder.ivCapaJogo);

        if (jogo.tipo.equals(this.tipoDescontoJogos)) {
            jogo.desconto = this.descontoJogos;
            holder.faixaOverlay.setBackgroundColor(ContextCompat.getColor(holder.context, R.color.cardDesconto));
        }
    }

    public void adicionarJogo(JogoSnes jogo) {
        this.jogos.add(jogo);
        // notifyItemChanged é mais otimizado que o notifyDataSetChanged
        // pois informamos exatamente as posições que mudaram
        this.notifyItemChanged(this.jogos.size() - 1);
    }

    @Override
    public int getItemCount() {
        return this.jogos.size();
    }

    // 2. Classe aninhada que representa o ViewHolder do Adapter/Recycler
    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout faixaOverlay;
        TextView lblTitulo, lblAno;
        ImageView ivCapaJogo;
        Context context;

        public ViewHolder(View v) {
            super(v);
            this.faixaOverlay = (LinearLayout)v.findViewById(R.id.faixa_overlay_card);
            this.lblTitulo = (TextView)v.findViewById(R.id.lblTitulo);
            this.lblAno = (TextView)v.findViewById(R.id.lblAno);
            this.ivCapaJogo = (ImageView)v.findViewById(R.id.ivCapaJogo);
            this.context = v.getContext();
            v.setOnClickListener((MainActivity)this.context);
            v.setOnLongClickListener((MainActivity)this.context);
        }
    }
}
