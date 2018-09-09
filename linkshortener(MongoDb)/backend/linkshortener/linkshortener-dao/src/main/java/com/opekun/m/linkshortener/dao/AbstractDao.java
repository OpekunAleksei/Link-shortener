package com.opekun.m.linkshortener.dao;

import com.opekun.m.linkshortener.api.dao.IGenericDao;
import com.opekun.m.linkshortener.model.generic.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public abstract class AbstractDao<T extends Model> implements IGenericDao<T> {

    private static final String ID = "id";
    private final Class<T> clazz;
    @Autowired
    private MongoTemplate mongoTemplate;

    protected final MongoTemplate getMongoOperations() {
        return mongoTemplate;
    }

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(Query.query(Criteria.where(ID).is(id)), this.clazz);
    }

    @Override
    public T getById(String id) {
        return mongoTemplate.findOne(Query.query(Criteria.where(ID).is(id)), this.clazz);
    }

    @Override
    public T saveUpdate(T entity) {
        mongoTemplate.save(entity);
        return entity;
    }

    @Override
    public List<T> getAll() {
        return mongoTemplate.findAll(this.clazz);
    }
}
