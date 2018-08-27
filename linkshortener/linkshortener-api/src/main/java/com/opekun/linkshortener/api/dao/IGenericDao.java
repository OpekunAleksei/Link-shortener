package com.opekun.linkshortener.api.dao;

import java.util.List;

public interface IGenericDao<T> {

    public void delete(Long id);

    public List<T> getAll();

    public T getById(Long id);

    public T update(T entity);

    public T save(T entity);

}
