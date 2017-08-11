package com.equifax.idmart.http;

/**
 * @author trevor.brooks
 */
public class BlankHttpClient extends HttpClientBase{
    @Override
    protected String getMediaType() {
        return null;
    }
}
