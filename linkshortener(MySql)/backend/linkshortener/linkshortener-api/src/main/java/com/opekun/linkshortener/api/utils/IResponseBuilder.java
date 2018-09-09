package com.opekun.linkshortener.api.utils;

import java.util.Map;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IResponseBuilder {

    public Map<String, Object> createResponse(Boolean success, String errMsg, Object data);
}
