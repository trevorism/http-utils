package com.trevorism.http;

import java.util.HashMap;
import java.util.Map;

public class HeadersHttpResponse {

    private final String value;
    private final Map<String,String> headers;
    private final int statusCode;

    public HeadersHttpResponse(String value) {
        this(value, new HashMap<>());
    }

    public HeadersHttpResponse(String value, Map<String, String> headers) {
        this(value, headers, 200);
    }

    public HeadersHttpResponse(String value, Map<String, String> headers, int statusCode) {
        this.value = value;
        this.headers = headers;
        this.statusCode = statusCode;
    }

    public String getValue() {
        return value;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
