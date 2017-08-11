package com.trevorism.http;

/**
 * @author trevor.brooks
 */
public class BlankHttpClient extends HttpClientBase{
    @Override
    protected String getMediaType() {
        return null;
    }
}
