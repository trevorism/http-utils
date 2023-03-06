package com.trevorism.http;

import java.util.Map;

public class HeadersHttpResponse {

    private final String value;
    private final Map<String,String> headers;

    public HeadersHttpResponse(String value, Map<String, String> headers) {
        this.value = value;
        this.headers = headers;
    }

    public String getValue() {
        return value;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
