package com.trevorism.http.headers;

import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.Map;

/**
 * @author tbrooks
 */
public interface HeadersHttpClient {

    String CORRELATION_ID_HEADER_KEY = "X-Correlation-ID";

    /**
     * Performs an HTTP GET
     *
     * @param url The url to GET
     * @param headers The HTTP headers to send with the request
     * @return The response object
     */
    CloseableHttpResponse get(String url, Map<String,String> headers);

    /**
     * Performs an HTTP POST
     *
     * @param url        The url to POST
     * @param serialized The serialized item to POST
     * @param headers The HTTP headers to send with the request
     * @return The response object
     */
    CloseableHttpResponse post(String url, String serialized, Map<String,String> headers);

    /**
     * Performs an HTTP PUT
     *
     * @param url        The url to PUT
     * @param serialized The serialized item to PUT
     * @param headers The HTTP headers to send with the request
     * @return The response object
     */
    CloseableHttpResponse put(String url, String serialized, Map<String,String> headers);

    /**
     * Performs an HTTP PATCH
     *
     * @param url        The url to PATCH
     * @param serialized The serialized item to PUT
     * @param headers The HTTP headers to send with the request
     * @return The response object
     */
    CloseableHttpResponse patch(String url, String serialized, Map<String,String> headers);

    /**
     * Performs an HTTP DELETE
     *
     * @param url The url to DELETE
     * @param headers The HTTP headers to send with the request
     * @return The response object
     */
    CloseableHttpResponse delete(String url, Map<String,String> headers);
}
