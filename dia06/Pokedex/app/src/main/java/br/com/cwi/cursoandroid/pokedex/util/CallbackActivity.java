package br.com.cwi.cursoandroid.pokedex.util;

import com.android.volley.VolleyError;

public interface CallbackActivity<T> {
    void onSuccess(T response);
    void onError(VolleyError volleyError);
}
