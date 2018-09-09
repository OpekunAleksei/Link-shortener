package com.opekun.linkshortener.model.exceptions;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class GetLinkException extends Exception {

    private static final String MSG = "Link with that short link didnt exist";

    public GetLinkException() {
        super(MSG);
    }
}
