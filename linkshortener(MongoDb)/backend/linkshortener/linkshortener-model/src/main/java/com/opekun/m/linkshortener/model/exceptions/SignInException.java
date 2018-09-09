package com.opekun.m.linkshortener.model.exceptions;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class SignInException extends Exception {

    private static final String MSG = "Wrong password or login";

    public SignInException() {
        super(MSG);
    }
}
