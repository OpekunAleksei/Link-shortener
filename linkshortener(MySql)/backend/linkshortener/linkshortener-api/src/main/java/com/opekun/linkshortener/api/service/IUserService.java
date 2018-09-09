package com.opekun.linkshortener.api.service;

import com.opekun.linkshortener.model.User;
import com.opekun.linkshortener.model.exceptions.LoginExistException;
import com.opekun.linkshortener.model.exceptions.SignInException;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IUserService {

    public User createUser(User user);

    public User getUserForSignIn(User user) throws SignInException;

    public void chekUserLogin(String login) throws LoginExistException;

    public User getUserById(Long id);

}
