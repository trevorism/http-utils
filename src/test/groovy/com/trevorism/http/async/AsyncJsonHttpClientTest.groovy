package com.trevorism.http.async

import org.asynchttpclient.ListenableFuture
import org.asynchttpclient.Response
import org.junit.Test

/**
 * @author trevor.brooks
 */
class AsyncJsonHttpClientTest {

    private AsyncJsonHttpClient client = new AsyncJsonHttpClient()
    private String url = "https://endpoint-tester-dot-trevorism-testing.appspot.com/api/json"

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
