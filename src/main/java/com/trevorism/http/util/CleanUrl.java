package com.trevorism.http.util;

/**
 * @author trevor.brooks
 */
public class CleanUrl {

    private CleanUrl(){}

    public static String startWithHttps(String url) {
        if (!url.startsWith("http"))
            url = "https://" + url;
        return url;
    }

}
