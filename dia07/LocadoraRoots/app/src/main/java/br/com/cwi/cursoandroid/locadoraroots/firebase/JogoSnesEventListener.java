package br.com.cwi.cursoandroid.locadoraroots.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import br.com.cwi.cursoandroid.locadoraroots.models.JogoSnes;
import br.com.cwi.cursoandroid.locadoraroots.utils.AsyncDataHandler;

public class JogoSnesEventListener implements ChildEventListener {

    private AsyncDataHandler<JogoSnes> jogoHandler;

    public JogoSnesEventListener(AsyncDataHandler<JogoSnes> jogoHandler) {
        this.jogoHandler = jogoHandler;
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        JogoSnes jogo = criarJogo(dataSnapshot);
        this.jogoHandler.onDataAdded(jogo);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        JogoSnes jogo = criarJogo(dataSnapshot);
        this.jogoHandler.onDataChanged(jogo);
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        JogoSnes jogo = criarJogo(dataSnapshot);
        this.jogoHandler.onDataRemoved(jogo);
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        JogoSnes jogo = criarJogo(dataSnapshot);
        this.jogoHandler.onDataMoved(jogo);
    }

    private JogoSnes criarJogo(DataSnapshot dataSnapshot) {
        JogoSnes jogo = dataSnapshot.getValue(JogoSnes.class);
        jogo.id = Integer.valueOf(dataSnapshot.getKey());
        return jogo;
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // TODO: logar no firebase
    }
}
