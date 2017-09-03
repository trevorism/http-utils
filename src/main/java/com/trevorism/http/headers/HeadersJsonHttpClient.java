package com.trevorism.http.headers;

/**
 * @author trevor.brooks
 */
public class HeadersJsonHttpClient extends HeadersHttpClientBase {

    @Override
    protected String getMediaType() {
        return "application/json";
    }

}
