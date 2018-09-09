package com.opekun.m.linkshortener.api.service;

import com.opekun.m.linkshortener.model.User;
import com.opekun.m.linkshortener.model.exceptions.LoginExistException;
import com.opekun.m.linkshortener.model.exceptions.SignInException;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IUserService {

    public User createUser(User user);

    public User getUserForSignIn(User user) throws SignInException;

    public void chekUserLogin(String login) throws LoginExistException;

}
