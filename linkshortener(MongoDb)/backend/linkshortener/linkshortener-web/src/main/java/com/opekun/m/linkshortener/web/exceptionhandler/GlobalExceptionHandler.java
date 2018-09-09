package com.opekun.m.linkshortener.web.exceptionhandler;

import com.opekun.m.linkshortener.api.utils.IErrMsgHandler;
import com.opekun.m.linkshortener.api.utils.IResponseBuilder;
import com.opekun.m.linkshortener.model.exceptions.GetLinkException;
import com.opekun.m.linkshortener.model.exceptions.LoginExistException;
import com.opekun.m.linkshortener.model.exceptions.SignInException;
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
    private final static String LOGIN_EXIST_EXCEPTION = "LoginExist";
    private final static String GET_LINK_EXCEPTION = "GetLinkException";
    private final static String UNKNOW_EXCEPTION = "UnknownException";

    @Autowired
    private IResponseBuilder responseBuilder;
    @Autowired
    private IErrMsgHandler exceptionMsgHandler;

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody
    Map<String, Object> unknownException(Exception ex) {
        return responseBuilder.createResponse(Boolean.FALSE, exceptionMsgHandler.getErrCodeByException(UNKNOW_EXCEPTION), null);
    }

    @ExceptionHandler(value = SignInException.class)
    public @ResponseBody
    Map<String, Object> signInException(SignInException ex) {
        return responseBuilder.createResponse(Boolean.FALSE, exceptionMsgHandler.getErrCodeByException(SIGN_IN_EXCEPTION), null);
    }

    @ExceptionHandler(value = LoginExistException.class)
    public @ResponseBody
    Map<String, Object> loginException(LoginExistException ex) {
        return responseBuilder.createResponse(Boolean.FALSE, exceptionMsgHandler.getErrCodeByException(LOGIN_EXIST_EXCEPTION), null);
    }

    @ExceptionHandler(value = GetLinkException.class)
    public @ResponseBody
    Map<String, Object> getLinkException(GetLinkException ex) {
        return responseBuilder.createResponse(Boolean.FALSE, exceptionMsgHandler.getErrCodeByException(GET_LINK_EXCEPTION), null);
    }
}
