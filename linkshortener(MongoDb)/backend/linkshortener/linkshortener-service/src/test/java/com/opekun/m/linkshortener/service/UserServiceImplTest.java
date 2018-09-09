package com.opekun.m.linkshortener.service;

import com.opekun.m.linkshortener.api.dao.IUserDao;
import com.opekun.m.linkshortener.api.service.IUserService;
import com.opekun.m.linkshortener.model.User;
import com.opekun.m.linkshortener.model.exceptions.LoginExistException;
import com.opekun.m.linkshortener.model.exceptions.SignInException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:service-context.xml")
public class UserServiceImplTest {

    @Autowired
    public IUserService testUserServise;
    @Autowired
    public IUserDao testUserDao;
    public User user;

    public UserServiceImplTest() {
    }

    @Before
    public void setUp() {
        user = new User("alex", "123");
        this.user = this.testUserServise.createUser(user);
    }

    @After
    public void tearDown() {
        this.testUserDao.delete(this.user.getId());
    }

    /**
     * Test of getUserForSignIn method, of class UserServiceImpl.
     */
    @Test(expected = SignInException.class)
    public void testGetUserForSignIn() throws Exception {
        System.out.println("getUserForSignIn");
        User user = new User("alex", "1233");
        User result = this.testUserServise.getUserForSignIn(user);
        assertNotEquals(result, null);
    }

    /**
     * Test of chekUserLogin method, of class UserServiceImpl.
     */
    @Test(expected = LoginExistException.class)
    public void testChekUserLogin() throws Exception {
        System.out.println("chekUserLogin");
        String login = "alex";
        this.testUserServise.chekUserLogin(login);
    }

}
