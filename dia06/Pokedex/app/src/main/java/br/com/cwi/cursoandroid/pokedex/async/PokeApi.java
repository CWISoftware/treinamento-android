package br.com.cwi.cursoandroid.pokedex.async;

// https://developer.android.com/training/volley/index.html

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.cwi.cursoandroid.pokedex.util.CallbackActivity;

public class PokeApi {
    CallbackActivity activity;
    final String BASE_API_URL = "http://pokeapi.co/api/v2";
    private static final String LOG_CONTEXT = "PokeApi";

    public PokeApi(CallbackActivity activity) {
        this.activity = activity;
    }

    public void fetch(int id) {
        RequestQueue queue = Volley.newRequestQueue((Context)this.activity);
        String url = String.format("%s/pokemon/%s", BASE_API_URL, id);
        StringRequest strRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            activity.onSuccess(json.getString("name"));
                        } catch (JSONException je) {
                            Log.e(LOG_CONTEXT, je.getMessage(), je);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        activity.onError(error);
                    }
                }
        );
        queue.add(strRequest);
    }
}
