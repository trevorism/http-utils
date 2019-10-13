package com.trevorism.http.async

import org.asynchttpclient.ListenableFuture
import org.asynchttpclient.Response
import org.junit.Test

/**
 * @author trevor.brooks
 */
class AsyncJsonHttpClientTest {

    private com.trevorism.http.async.AsyncJsonHttpClient client = new com.trevorism.http.async.AsyncJsonHttpClient()
    private String url = "https://endpoint-tester-dot-trevorism-gcloud.appspot.com/api/json"

    @Test
    void testGet() {
        ListenableFuture<Response> future = client.get(url)
        assert "hello json" == future.get().getResponseBody()
    }

    @Test
    void testPost() {
        ListenableFuture<Response> future = client.post(url, "{}")
        assert "{}" == future.get().getResponseBody()
    }

    @Test
    void testPut() {
        ListenableFuture<Response> future = client.put(url, "{}")
        assert "{}" == future.get().getResponseBody()
    }

    @Test
    void testDelete() {
        ListenableFuture<Response> future = client.delete(url)
        assert "delete json" == future.get().getResponseBody()
    }
}
