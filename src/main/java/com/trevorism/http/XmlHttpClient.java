package com.trevorism.http;

/**
 * @author trevor.brooks
 */
public class XmlHttpClient extends HttpClientBase {

    @Override
    protected String getMediaType() {
        return "text/xml";
    }

}
