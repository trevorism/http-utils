package com.equifax.idmart.http;

import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;

/**
 * @author trevor.brooks
 */
public interface AsyncHttpClient {

    /**
     * Performs an HTTP GET
     *
     * @param url The url to GET
     * @return The string content of the response
     */
    ListenableFuture<Response> get(String url);

    /**
     * Performs an HTTP POST
     *
     * @param url        The url to POST
     * @param serialized The serialized item to POST
     * @return The string content of the response
     */
    ListenableFuture<Response> post(String url, String serialized);

    /**
     * Performs an HTTP PUT
     *
     * @param url        The url to PUT
     * @param serialized The serialized item to PUT
     * @return The string content of the response
     */
    ListenableFuture<Response> put(String url, String serialized);

    /**
     * Performs an HTTP DELETE
     *
     * @param url The url to DELETE
     * @return The string content of the response
     */
    ListenableFuture<Response> delete(String url);
}
