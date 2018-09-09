package com.opekun.m.linkshortener.api.dao;

import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IGenericDao<T> {

    public void delete(String id);

    public List<T> getAll();

    public T getById(String id);

    public T saveUpdate(T entity);

}
