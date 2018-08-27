package com.opekun.linkshortener.web.exceptionhandler;

import com.opekun.linkshortener.api.utils.IResponseBuilder;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static String SIGN_IN_EXCEPTION = "SignInException";
    private final static String CREATE_DATA_EXCEPTION = "DataIntegrityViolationException";
    private final static String LOGIN_EXIST_EXCEPTION = "LoginExist";
    private final static String UNKNOW_EXCEPTION = "UnknownException";

    @Autowired
    private IResponseBuilder responseBuilder;

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody
    Map<String, Object> unknownException(Exception ex) {
        return responseBuilder.createResponse(Boolean.FALSE, "asd", null);
    }
}
