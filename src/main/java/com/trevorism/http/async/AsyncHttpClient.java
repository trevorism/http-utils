package com.trevorism.http.async;

import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.core5.concurrent.FutureCallback;

import java.util.concurrent.Future;

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
    Future<SimpleHttpResponse> get(String url, FutureCallback<SimpleHttpResponse> callback);

    /**
     * Performs an HTTP POST
     *
     * @param url        The url to POST
     * @param serialized The serialized item to POST
     * @return The string content of the response
     */
    Future<SimpleHttpResponse> post(String url, String serialized, FutureCallback<SimpleHttpResponse> callback);

    /**
     * Performs an HTTP PUT
     *
     * @param url        The url to PUT
     * @param serialized The serialized item to PUT
     * @return The string content of the response
     */
    Future<SimpleHttpResponse> put(String url, String serialized, FutureCallback<SimpleHttpResponse> callback);

    /**
     * Performs an HTTP PATCH
     *
     * @param url        The url to PATCH
     * @param serialized The serialized item to PATCH
     * @return The string content of the response
     */
    Future<SimpleHttpResponse> patch(String url, String serialized, FutureCallback<SimpleHttpResponse> callback);

    /**
     * Performs an HTTP DELETE
     *
     * @param url The url to DELETE
     * @return The string content of the response
     */
    Future<SimpleHttpResponse> delete(String url, FutureCallback<SimpleHttpResponse> callback);
}
