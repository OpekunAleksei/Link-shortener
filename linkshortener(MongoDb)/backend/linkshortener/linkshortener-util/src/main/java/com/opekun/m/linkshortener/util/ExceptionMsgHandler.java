package com.opekun.m.linkshortener.util;

import com.opekun.m.linkshortener.api.utils.IErrMsgHandler;
import java.util.Properties;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Component
public class ExceptionMsgHandler implements IErrMsgHandler {

    @Resource(name = "errConfiguration")
    private Properties errConfiguration;

    @Override
    public String getErrCodeByException(String name) {
        return this.errConfiguration.getProperty(name);

    }

}
