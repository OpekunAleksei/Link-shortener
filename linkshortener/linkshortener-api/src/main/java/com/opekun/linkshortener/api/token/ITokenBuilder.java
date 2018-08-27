package com.opekun.linkshortener.api.token;

import com.opekun.linkshortener.model.User;

public interface ITokenBuilder {

    public String createWebToken(User user);
}
