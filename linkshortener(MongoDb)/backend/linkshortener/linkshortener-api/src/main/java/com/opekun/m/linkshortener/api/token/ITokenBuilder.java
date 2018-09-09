package com.opekun.m.linkshortener.api.token;

import com.opekun.m.linkshortener.model.User;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ITokenBuilder {

    public String createWebToken(User user);
}
