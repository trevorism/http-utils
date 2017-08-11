package com.equifax.idmart.http;

import org.asynchttpclient.*;

/**
 * @author trevor.brooks
 */
public class AsyncBlankHttpClient implements com.equifax.idmart.http.AsyncHttpClient {

    private final org.asynchttpclient.AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();

    @Override
    public ListenableFuture<Response> get(String url) {
        return asyncHttpClient.prepareGet(CleanUrl.startWithHttp(url)).execute();
    }

    @Override
    public ListenableFuture<Response> post(String url, String input) {
        RequestBuilder builder = new RequestBuilder("POST");
        Request request = builder.setUrl(CleanUrl.startWithHttp(url)).setBody(input).build();
        return asyncHttpClient.executeRequest(request);
    }

    @Override
    public ListenableFuture<Response> put(String url, String input) {
        RequestBuilder builder = new RequestBuilder("PUT");
        Request request = builder.setUrl(CleanUrl.startWithHttp(url)).setBody(input).build();
        return asyncHttpClient.executeRequest(request);
    }

    @Override
    public ListenableFuture<Response> delete(String url) {
        return asyncHttpClient.prepareDelete(CleanUrl.startWithHttp(url)).execute();
    }
}