package com.equifax.idmart.http;

/**
 * @author trevor.brooks
 */
public class CleanUrl {

    private CleanUrl(){}

    public static String startWithHttp(String url) {
        if (!url.startsWith("http"))
            url = "http://" + url;
        return url;
    }

}
