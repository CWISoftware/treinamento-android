package br.com.cwi.cursoandroid.locadoraroots.utils;

public interface AsyncDataHandler<T> {
    void onDataAdded(T data);
    void onDataChanged(T data);
    void onDataRemoved(T data);
    void onDataMoved(T data);
}
