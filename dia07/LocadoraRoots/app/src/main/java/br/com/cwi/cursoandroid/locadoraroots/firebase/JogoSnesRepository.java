package br.com.cwi.cursoandroid.locadoraroots.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.cwi.cursoandroid.locadoraroots.models.JogoSnes;
import br.com.cwi.cursoandroid.locadoraroots.utils.AsyncDataHandler;

public class JogoSnesRepository {

    private AsyncDataHandler<JogoSnes> dataHandler;

    public JogoSnesRepository(AsyncDataHandler<JogoSnes> dataHandler) {
        this.dataHandler = dataHandler;
    }

    public void enqueueGetAll() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference versaoRef = database.getReference("jogos_snes");
        ChildEventListener jogoEventListener = new JogoSnesEventListener(this.dataHandler);
        versaoRef.orderByChild("anoLancamento").addChildEventListener(jogoEventListener);
    }

}
