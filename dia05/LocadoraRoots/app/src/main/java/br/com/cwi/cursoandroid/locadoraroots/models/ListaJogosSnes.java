package br.com.cwi.cursoandroid.locadoraroots.models;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.cwi.cursoandroid.locadoraroots.utils.Constantes;

public class ListaJogosSnes {

    private static final List<JogoSnes> JOGOS_INICIAIS = new ArrayList<>(Arrays.asList(
            new JogoSnes("Super Mario World", "https://upload.wikimedia.org/wikipedia/pt/0/06/Super-Mario-World.jpg", "Adventure", 1990),
            new JogoSnes("The Legend of Zelda: A Link to the past", "http://www.gamexplain.com/storyimages/1334613417588436_40267_front.jpg", "RPG", 1991),
            new JogoSnes("Chrono Trigger", "http://www.cogumelando.com.br/wp-content/upLoads/chrono-trigger-cover-snes.jpg", "RPG", 1995)
    ));

    private SharedPreferences sharedPreferences;
    private List<JogoSnes> jogos;

    public ListaJogosSnes(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.jogos = new ArrayList<>();
        if (this.syncRead().isEmpty()) {
            this.jogos = JOGOS_INICIAIS;
            this.syncWrite();
        }
    }

    private void syncWrite() {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        String csv = this.getCSV();
        editor.putString(Constantes.LISTA_JOGOS, csv);
        // https://stackoverflow.com/questions/5960678/whats-the-difference-between-commit-and-apply-in-shared-preference
        editor.apply();
    }

    private List<JogoSnes> syncRead() {
        List<JogoSnes> jogosDisco = new ArrayList<>();
        String csv = this.sharedPreferences.getString(Constantes.LISTA_JOGOS, "");
        if (!csv.isEmpty()) {
            String[] jogosCsv = csv.trim().split("\n");

            for (String jogoCsv : jogosCsv) {
                jogosDisco.add(JogoSnes.from(jogoCsv));
            }
        }
        return jogosDisco;
    }

    public List<JogoSnes> getAll() {
        this.jogos = this.syncRead();
        return this.jogos;
    }

    public void remover(int posicao) {
        this.jogos.remove(posicao);
        this.syncWrite();
    }

    public String getCSV() {
        StringBuilder stringBuilder = new StringBuilder();

        for (JogoSnes jogoSnes : this.jogos) {
            stringBuilder.append(jogoSnes.getCSV() + "\n");
        }

        return stringBuilder.toString();
    }
}










