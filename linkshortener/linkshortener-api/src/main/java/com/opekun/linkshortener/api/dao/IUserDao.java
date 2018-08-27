package com.opekun.linkshortener.api.dao;

import com.opekun.linkshortener.model.User;

public interface IUserDao extends IGenericDao<User> {

    public User getUserByNickname(String nickname);

    public User getUserByLogin(String login);
}
