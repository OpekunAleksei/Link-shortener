package com.opekun.m.linkshortener.service;

import com.opekun.m.linkshortener.api.dao.IUserDao;
import com.opekun.m.linkshortener.api.service.IUserService;
import com.opekun.m.linkshortener.model.User;
import com.opekun.m.linkshortener.model.exceptions.LoginExistException;
import com.opekun.m.linkshortener.model.exceptions.SignInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User createUser(User user) {
        String encryptionPassword = this.encryptionPassword(user);
        user.setPassword(encryptionPassword);
        return this.userDao.saveUpdate(user);
    }

    @Override

    public User getUserForSignIn(User user) throws SignInException {
        User persistentUser = this.userDao.getUserByLogin(user.getLogin());
        if (persistentUser != null && persistentUser.getPassword().equals(encryptionPassword(user))) {
            return persistentUser;
        } else {
            throw new SignInException();
        }
    }

    @Override
    public void chekUserLogin(String login) throws LoginExistException {
        if (this.userDao.getUserByLogin(login) != null) {
            throw new LoginExistException();
        }
    }

    private String encryptionPassword(User user) {
        Integer password = user.getPassword().hashCode();
        return password.toString();
    }

}
