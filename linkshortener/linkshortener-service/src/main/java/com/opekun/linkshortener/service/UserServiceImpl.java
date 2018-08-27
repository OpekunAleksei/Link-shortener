package com.opekun.linkshortener.service;

import com.opekun.linkshortener.api.dao.IUserDao;
import com.opekun.linkshortener.api.service.IUserService;
import com.opekun.linkshortener.model.User;
import com.opekun.linkshortener.model.exceptions.LoginExistException;
import com.opekun.linkshortener.model.exceptions.NicknameExistException;
import com.opekun.linkshortener.model.exceptions.SignInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User createUser(User user) {
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

    @Override
    public void checkUserNickname(String nickname) throws NicknameExistException{
        if (this.userDao.getUserByNickname(nickname) != null) {
            throw new NicknameExistException();
        }
    }

    private String encryptionPassword(User user) {
        Integer password = user.getPassword().hashCode();
        return password.toString();
    }
}
