package com.opekun.linkshortener.web.repository;

import com.opekun.linkshortener.api.token.ITokenRepository;
import com.opekun.linkshortener.model.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class TokenRepository implements ITokenRepository {

    private final Map<String, User> usersToken;

    public TokenRepository() {
        usersToken = new HashMap<>();
    }

    @Override
    public User getUserByToken(String token) {
        return this.usersToken.get(token);
    }

    @Override
    public void setUserToken(User user, String token) {
        this.usersToken.put(token, user);
    }

    @Override
    public void destroyUserToken(String token) {
        this.usersToken.remove(token);
    }

}
