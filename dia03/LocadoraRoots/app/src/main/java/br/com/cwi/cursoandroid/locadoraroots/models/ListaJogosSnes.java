package br.com.cwi.cursoandroid.locadoraroots.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaJogosSnes {
    private static List<JogoSnes> JOGOS = new ArrayList<>(Arrays.asList(
            new JogoSnes("Super Mario World", "https://upload.wikimedia.org/wikipedia/pt/0/06/Super-Mario-World.jpg", "Adventure", 1990),
            new JogoSnes("The Legend of Zelda: A Link to the past", "http://www.gamexplain.com/storyimages/1334613417588436_40267_front.jpg", "RPG", 1991),
            new JogoSnes("Chrono Trigger", "http://www.cogumelando.com.br/wp-content/upLoads/chrono-trigger-cover-snes.jpg", "RPG", 1995)
    ));

    public static List<JogoSnes> getAll() {
        return JOGOS;
    }

    public static void remover(int posicao) {
        JOGOS.remove(posicao);
    }
}
