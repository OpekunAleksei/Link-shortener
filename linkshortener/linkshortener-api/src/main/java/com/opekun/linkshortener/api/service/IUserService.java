package com.opekun.linkshortener.api.service;

import com.opekun.linkshortener.model.User;
import com.opekun.linkshortener.model.exceptions.LoginExistException;
import com.opekun.linkshortener.model.exceptions.NicknameExistException;
import com.opekun.linkshortener.model.exceptions.SignInException;

public interface IUserService {

    public User createUser(User user);

    public User getUserForSignIn(User user) throws SignInException;

    public void chekUserLogin(String login) throws LoginExistException;

    public void checkUserNickname(String nickname) throws NicknameExistException;

}
