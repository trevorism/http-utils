package com.trevorism.http.headers;

/**
 * @author trevor.brooks
 */
public class HeadersBlankHttpClient extends HeadersHttpClientBase {
    @Override
    protected String getMediaType() {
        return null;
    }
}
