package com.trevorism.http.async;

import com.trevorism.http.util.CleanUrl;
import org.asynchttpclient.*;

/**
 * @author trevor.brooks
 */
public class AsyncBlankHttpClient implements AsyncHttpClient {

    private final org.asynchttpclient.AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();

    /**
     * Async HTTP GET
     * @param url The url to GET
     * @return future with the response
     */
    @Override
    public ListenableFuture<Response> get(String url) {
        return asyncHttpClient.prepareGet(CleanUrl.startWithHttps(url)).execute();
    }

    /**
     * Async HTTP POST
     * @param url The url to POST
     * @param input The request content as a string
     * @return future with the response
     */
    @Override
    public ListenableFuture<Response> post(String url, String input) {
        RequestBuilder builder = new RequestBuilder("POST");
        Request request = builder.setUrl(CleanUrl.startWithHttps(url)).setBody(input).build();
        return asyncHttpClient.executeRequest(request);
    }

    /**
     * Async HTTP PUT
     * @param url The url to PUT
     * @param input The request content as a string
     * @return future with the response
     */
    @Override
    public ListenableFuture<Response> put(String url, String input) {
        RequestBuilder builder = new RequestBuilder("PUT");
        Request request = builder.setUrl(CleanUrl.startWithHttps(url)).setBody(input).build();
        return asyncHttpClient.executeRequest(request);
    }

    /**
     * Async HTTP DELETE
     * @param url The url to DELETE
     * @return future with the response
     */
    @Override
    public ListenableFuture<Response> delete(String url) {
        return asyncHttpClient.prepareDelete(CleanUrl.startWithHttps(url)).execute();
    }
}