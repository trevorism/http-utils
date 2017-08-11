package com.equifax.idmart.http;

/**
 * @author trevor.brooks
 */
public class JsonHttpClient extends HttpClientBase {

    @Override
    protected String getMediaType() {
        return "application/json";
    }

}
