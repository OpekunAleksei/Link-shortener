package com.opekun.m.linkshortener.api.token;

import com.opekun.m.linkshortener.model.User;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ITokenRepository {

    public User getUserByToken(String token);

    public void setUserToken(User user, String token);

    public void destroyUserToken(String token);
}
