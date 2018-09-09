package com.opekun.m.linkshortener.api.dao;

import com.opekun.m.linkshortener.model.User;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IUserDao extends IGenericDao<User> {

    public User getUserByLogin(String login);
}
