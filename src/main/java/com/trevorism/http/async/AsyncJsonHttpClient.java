package com.trevorism.http.async;

import com.trevorism.http.util.CleanUrl;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.reactor.IOReactorStatus;

import java.util.concurrent.Future;

/**
 * @author trevor.brooks
 */
public class AsyncJsonHttpClient implements AsyncHttpClient {

    private CloseableHttpAsyncClient asyncHttpClient = HttpAsyncClients.createDefault();

    /**
     * Async HTTP GET
     *
     * @param url The url to GET
     * @return future with the response
     */
    @Override
    public Future<SimpleHttpResponse> get(String url, FutureCallback<SimpleHttpResponse> callback) {
        if(asyncHttpClient.getStatus() == IOReactorStatus.INACTIVE){
            asyncHttpClient.start();
        }
        SimpleHttpRequest request = SimpleRequestBuilder.get(CleanUrl.startWithHttps(url)).build();
        return asyncHttpClient.execute(request, callback);
    }

    /**
     * Async HTTP POST
     *
     * @param url   The url to POST
     * @param input The request content as a string
     * @return future with the response
     */
    @Override
    public Future<SimpleHttpResponse> post(String url, String input, FutureCallback<SimpleHttpResponse> callback) {
        if(asyncHttpClient.getStatus() == IOReactorStatus.INACTIVE){
            asyncHttpClient.start();
        }
        SimpleHttpRequest request = SimpleRequestBuilder.post(CleanUrl.startWithHttps(url)).build();
        request.setBody(input, ContentType.APPLICATION_JSON);
        return asyncHttpClient.execute(request, callback);
    }

    /**
     * Async HTTP PUT
     *
     * @param url   The url to PUT
     * @param input The request content as a string
     * @return future with the response
     */
    @Override
    public Future<SimpleHttpResponse> put(String url, String input, FutureCallback<SimpleHttpResponse> callback) {
        if(asyncHttpClient.getStatus() == IOReactorStatus.INACTIVE){
            asyncHttpClient.start();
        }
        SimpleHttpRequest request = SimpleRequestBuilder.put(CleanUrl.startWithHttps(url)).build();
        request.setBody(input, ContentType.APPLICATION_JSON);
        return asyncHttpClient.execute(request, callback);
    }

    /**
     * Async HTTP PATCH
     *
     * @param url   The url to PATCH
     * @param input The request content as a string
     * @return future with the response
     */
    @Override
    public Future<SimpleHttpResponse> patch(String url, String input, FutureCallback<SimpleHttpResponse> callback) {
        if(asyncHttpClient.getStatus() == IOReactorStatus.INACTIVE){
            asyncHttpClient.start();
        }
        SimpleHttpRequest request = SimpleRequestBuilder.patch(CleanUrl.startWithHttps(url)).build();
        request.setBody(input, ContentType.APPLICATION_JSON);
        return asyncHttpClient.execute(request, callback);
    }

    /**
     * Async HTTP DELETE
     *
     * @param url The url to DELETE
     * @return future with the response
     */
    @Override
    public Future<SimpleHttpResponse> delete(String url, FutureCallback<SimpleHttpResponse> callback) {
        if(asyncHttpClient.getStatus() == IOReactorStatus.INACTIVE){
            asyncHttpClient.start();
        }
        SimpleHttpRequest request = SimpleRequestBuilder.delete(CleanUrl.startWithHttps(url)).build();
        return asyncHttpClient.execute(request, callback);
    }
}
