package com.trevorism.http.headers;

/**
 * @author trevor.brooks
 */
public class HeadersXmlHttpClient extends HeadersHttpClientBase {

    @Override
    protected String getMediaType() {
        return "application/xml";
    }

}
