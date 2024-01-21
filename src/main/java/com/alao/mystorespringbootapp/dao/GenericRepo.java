package com.alao.mystorespringbootapp.dao;

public interface GenericRepo<T> {
    String generate(int position);

    Object getList();
    T getById (String id);
    T deleteById (String id);
    T update (T item);
    T save(T item);

}
