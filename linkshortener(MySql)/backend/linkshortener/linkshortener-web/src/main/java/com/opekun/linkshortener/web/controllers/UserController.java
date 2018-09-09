/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opekun.linkshortener.web.controllers;

import com.opekun.linkshortener.api.service.IUserService;
import com.opekun.linkshortener.api.token.ITokenBuilder;
import com.opekun.linkshortener.api.token.ITokenRepository;
import com.opekun.linkshortener.api.utils.IResponseBuilder;
import com.opekun.linkshortener.model.User;
import com.opekun.linkshortener.model.exceptions.LoginExistException;
import com.opekun.linkshortener.model.exceptions.SignInException;
import com.opekun.linkshortener.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ITokenBuilder tokenBuilder;
    @Autowired
    private ITokenRepository tokenRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IResponseBuilder responseBuilder;
    @Autowired
    private DozerBeanMapper mapper;

    @RequestMapping(path = "/chekLogin", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> checkUserLogin(@RequestBody String login) throws LoginExistException {
        this.userService.chekUserLogin(login);
        return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    Map<String, Object> createUser(@RequestBody User user) {
        userService.createUser(user);
        return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "/signIn", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> signIn(@RequestBody User user) throws SignInException {
        User userForSignIn = this.userService.getUserForSignIn(user);
        String token = tokenBuilder.createWebToken(userForSignIn);
        tokenRepository.setUserToken(userForSignIn, token);
        List<Object> response = new ArrayList<>();
        response.add(mapper.map(userForSignIn, UserDto.class));
        response.add(token);
        return responseBuilder.createResponse(Boolean.TRUE, null, response);
    }

    @RequestMapping(path = "/signOut", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> signOut(@RequestBody String token) {
        tokenRepository.destroyUserToken(token);
        return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

}
