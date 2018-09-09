package com.opekun.linkshortener.api.token;

import com.opekun.linkshortener.model.User;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ITokenBuilder {

    public String createWebToken(User user);
}
