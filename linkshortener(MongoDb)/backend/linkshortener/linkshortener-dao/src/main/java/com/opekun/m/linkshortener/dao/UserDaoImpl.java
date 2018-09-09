package com.opekun.m.linkshortener.dao;

import com.opekun.m.linkshortener.api.dao.IUserDao;
import com.opekun.m.linkshortener.model.User;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class UserDaoImpl extends AbstractDao<User> implements IUserDao {

    private static final String LOGIN = "login";

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getUserByLogin(String login) {
        MongoOperations mongoOperations = super.getMongoOperations();
        return mongoOperations.findOne(Query.query(Criteria.where(LOGIN).is(login)), User.class);
    }
}
