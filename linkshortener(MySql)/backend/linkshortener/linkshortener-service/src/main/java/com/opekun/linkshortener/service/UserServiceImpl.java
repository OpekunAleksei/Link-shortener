package com.opekun.linkshortener.service;

import com.opekun.linkshortener.api.dao.IUserDao;
import com.opekun.linkshortener.api.service.IUserService;
import com.opekun.linkshortener.model.User;
import com.opekun.linkshortener.model.exceptions.LoginExistException;
import com.opekun.linkshortener.model.exceptions.SignInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User createUser(User user) {
        String encryptionPassword = this.encryptionPassword(user);
        user.setPassword(encryptionPassword);
        return this.userDao.save(user);
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

    @Override
    public User getUserById(Long id) {
        return this.userDao.getById(id);
    }
}
