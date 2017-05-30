package br.com.cwi.cursoandroid.locadoraroots.models;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.cwi.cursoandroid.locadoraroots.utils.Constantes;

public class ListaJogosSnes {

    private static final List<JogoSnes> JOGOS_INICIAIS = new ArrayList<>();

//    private static final List<JogoSnes> JOGOS_INICIAIS = new ArrayList<>(Arrays.asList(
//            new JogoSnes("Chrono Trigger", "http://www.cogumelando.com.br/wp-content/upLoads/chrono-trigger-cover-snes.jpg", "RPG", 1995),
//            new JogoSnes("Super Mario World", "https://assets.catawiki.nl/assets/2014/8/17/1/c/6/1c656e3a-2601-11e4-972c-956521972b5b.jpg", "Aventura", 1990),
//            new JogoSnes("Street Fighter II Turbo", "http://vignette2.wikia.nocookie.net/capcomdatabase/images/f/f9/SFIITurboCoverScan.png/revision/latest?cb=20080806031401", "Luta", 1992),
//            new JogoSnes("The Legend of Zelda: A Link to the past", "https://s-media-cache-ak0.pinimg.com/originals/3d/4e/78/3d4e78abb05ffbadec5a63ef226ee1a9.jpg", "RPG", 1991)
//    ));

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

    public JogoSnes get(int posicao) {
        return this.jogos.get(posicao);
    }

    public void remover(int posicao) {
        this.jogos.remove(posicao);
        this.syncWrite();
    }

    public void adicionar(JogoSnes jogo) {
        this.jogos.add(jogo);
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










