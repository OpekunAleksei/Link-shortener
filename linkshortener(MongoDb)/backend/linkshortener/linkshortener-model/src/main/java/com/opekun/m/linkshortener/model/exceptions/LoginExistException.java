package com.opekun.m.linkshortener.model.exceptions;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class LoginExistException extends Exception {

    private static final String MSG = "This login alredy exsits";

    public LoginExistException() {
        super(MSG);
    }
}
