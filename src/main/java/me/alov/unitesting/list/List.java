package me.alov.unitesting.list;

public interface List<T> {

    T get(int index);
    void add(T data);
    void add(T[] data);
    void add(T data, int index);
    int size();
}
