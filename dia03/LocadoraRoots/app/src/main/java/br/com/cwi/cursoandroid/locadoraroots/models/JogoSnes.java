package br.com.cwi.cursoandroid.locadoraroots.models;

import java.io.Serializable;

public class JogoSnes implements Serializable {
    private String titulo, urlCapaJogo, tipo;
    private int anoLancamento;

    public JogoSnes(String titulo, String urlCapaJogo, String tipo, int anoLancamento) {
        this.titulo = titulo;
        this.urlCapaJogo = urlCapaJogo;
        this.tipo = tipo;
        this.anoLancamento = anoLancamento;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlCapaJogo() {
        return urlCapaJogo;
    }

    public String getTipo() {
        return tipo;
    }
}
