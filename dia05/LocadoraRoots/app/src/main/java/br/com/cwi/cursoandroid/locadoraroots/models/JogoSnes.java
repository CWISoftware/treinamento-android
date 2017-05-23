package br.com.cwi.cursoandroid.locadoraroots.models;

import java.io.Serializable;

public class JogoSnes implements Serializable {
    private String titulo, urlCapaJogo, tipo;
    private Integer anoLancamento;

    public JogoSnes(String titulo, String urlCapaJogo, String tipo, Integer anoLancamento) {
        this.titulo = titulo;
        this.urlCapaJogo = urlCapaJogo;
        this.tipo = tipo;
        this.anoLancamento = anoLancamento;
    }

    public Integer getAnoLancamento() {
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

    public String getCSV() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s,%s,%d,%s",
                this.titulo, this.tipo, this.anoLancamento, this.urlCapaJogo));
        return stringBuilder.toString();
    }
}











