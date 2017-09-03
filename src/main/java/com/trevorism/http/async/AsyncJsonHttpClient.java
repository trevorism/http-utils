package com.trevorism.http.async;

import com.trevorism.http.util.CleanUrl;
import org.asynchttpclient.*;

/**
 * @author trevor.brooks
 */
public class AsyncJsonHttpClient implements AsyncHttpClient {

    private final org.asynchttpclient.AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();

    /**
     * Async HTTP GET
     * @param url The url to GET
     * @return future with the response
     */
    @Override
    public ListenableFuture<Response> get(String url) {
        return asyncHttpClient.prepareGet(CleanUrl.startWithHttp(url)).execute();
    }

    /**
     * Async HTTP POST
     * @param url The url to POST
     * @param json The request content as json
     * @return future with the response
     */
    @Override
    public ListenableFuture<Response> post(String url, String json) {
        RequestBuilder builder = new RequestBuilder("POST");
        Request request = builder.setUrl(CleanUrl.startWithHttp(url)).setBody(json).setHeader("Content-Type", "application/json").build();
        return asyncHttpClient.executeRequest(request);
    }

    /**
     * Async HTTP PUT
     * @param url The url to PUT
     * @param json The request content as json
     * @return future with the response
     */
    @Override
    public ListenableFuture<Response> put(String url, String json) {
        RequestBuilder builder = new RequestBuilder("PUT");
        Request request = builder.setUrl(CleanUrl.startWithHttp(url)).setBody(json).setHeader("Content-Type", "application/json").build();
        return asyncHttpClient.executeRequest(request);
    }

    /**
     * Async HTTP DELETE
     * @param url The url to DELETE
     * @return future with the response
     */
    @Override
    public ListenableFuture<Response> delete(String url) {
        return asyncHttpClient.prepareDelete(CleanUrl.startWithHttp(url)).execute();
    }
}
