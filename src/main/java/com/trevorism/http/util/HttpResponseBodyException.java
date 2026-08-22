package com.trevorism.http.util;

import org.apache.hc.client5.http.HttpResponseException;

public class HttpResponseBodyException extends HttpResponseException {

    private final String responseBody;

    public HttpResponseBodyException(int statusCode, String reasonPhrase, String responseBody) {
        super(statusCode, reasonPhrase);
        this.responseBody = responseBody;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
