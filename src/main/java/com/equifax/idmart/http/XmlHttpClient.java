package com.equifax.idmart.http;

/**
 * @author trevor.brooks
 */
public class XmlHttpClient extends HttpClientBase {

    @Override
    protected String getMediaType() {
        return "application/xml";
    }

}
