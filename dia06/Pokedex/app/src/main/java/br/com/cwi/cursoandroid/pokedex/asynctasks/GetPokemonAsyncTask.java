package br.com.cwi.cursoandroid.pokedex.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import br.com.cwi.cursoandroid.pokedex.MainActivity;

public class GetPokemonAsyncTask extends AsyncTask<Integer, Void, JSONObject> {

    private static final String LOG_CATEGORY = "GetPokemonAsyncTask";

    MainActivity activity;

    public GetPokemonAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected JSONObject doInBackground(Integer... params) {
        Integer id = params[0];
        StringBuilder responseBuilder = new StringBuilder();
        try {
            String urlPokemon = String.format("%s/%s", "http://pokeapi.co/api/v2/pokemon", id);
            URL url = new URL(urlPokemon);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream in = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            Log.d(LOG_CATEGORY, responseBuilder.toString());
        } catch (MalformedURLException mue) {
            Log.e(LOG_CATEGORY, mue.getMessage(), mue);
        } catch (IOException ioException) {
            Log.e(LOG_CATEGORY, ioException.getMessage(), ioException);
        }
        JSONObject response = null;
        try {
            response = new JSONObject(responseBuilder.toString());
        } catch (JSONException je) {
            Log.e(LOG_CATEGORY, je.getMessage(), je);
        }
        return response;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        String nome = null;
        try {
            nome = jsonObject.getString("name");
        } catch (JSONException je) {
            Log.e(LOG_CATEGORY, je.getMessage(), je);
        } catch (NullPointerException npe) {
            Log.e(LOG_CATEGORY, npe.getMessage(), npe);
        }
        activity.renderizarNome(nome);
    }
}
