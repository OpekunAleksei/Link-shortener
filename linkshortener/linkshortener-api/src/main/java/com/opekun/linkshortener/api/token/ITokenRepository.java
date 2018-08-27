package com.opekun.linkshortener.api.token;

import com.opekun.linkshortener.model.User;

public interface ITokenRepository {

    public User getUserByToken(String token);

    public void setUserToken(User user, String token);

    public void destroyUserToken(String token);
}
