package com.trevorism.http;

import java.util.Map;

/**
 * @author trevor.brooks
 */
public interface HttpClient {
    /**
     * Performs an HTTP GET
     *
     * @param url The url to GET
     * @return The string content of the response
     */
    String get(String url);

    HeadersHttpResponse get(String url, Map<String, String> headers);

    /**
     * Performs an HTTP POST
     *
     * @param url        The url to POST
     * @param serialized The serialized item to POST
     * @return The string content of the response
     */
    String post(String url, String serialized);

    HeadersHttpResponse post(String url, String serialized, Map<String, String> headers);

    /**
     * Performs an HTTP PUT
     *
     * @param url        The url to PUT
     * @param serialized The serialized item to PUT
     * @return The string content of the response
     */
    String put(String url, String serialized);

    HeadersHttpResponse put(String url, String serialized, Map<String, String> headers);

    /**
     * Performs an HTTP PATCH
     *
     * @param url        The url to PATCH
     * @param serialized The serialized item to PATCH
     * @return The string content of the response
     */
    String patch(String url, String serialized);

    HeadersHttpResponse patch(String url, String serialized, Map<String, String> headers);

    /**
     * Performs an HTTP DELETE
     *
     * @param url The url to DELETE
     * @return The string content of the response
     */
    String delete(String url);

    HeadersHttpResponse delete(String url, Map<String, String> headers);
}
