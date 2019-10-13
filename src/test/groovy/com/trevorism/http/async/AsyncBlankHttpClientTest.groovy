package com.trevorism.http.async

import org.asynchttpclient.ListenableFuture
import org.asynchttpclient.Response
import org.junit.Test

/**
 * @author trevor.brooks
 */
class AsyncBlankHttpClientTest {

    private com.trevorism.http.async.AsyncBlankHttpClient client = new com.trevorism.http.async.AsyncBlankHttpClient()
    private String url = "https://endpoint-tester-dot-trevorism-gcloud.appspot.com/api/nospec"

    @Test
    void testGet() {
        ListenableFuture<Response> future = client.get(url)
        assert "hello" == future.get().getResponseBody()
    }

    @Test
    void testPost() {
        ListenableFuture<Response> future = client.post(url, "whaa")
        assert future.get().getResponseBody()
    }

    @Test
    void testPut() {
        ListenableFuture<Response> future = client.put(url, "whaa")
        assert future.get().getResponseBody()
    }

    @Test
    void testDelete() {
        ListenableFuture<Response> future = client.delete(url)
        assert "delete" == future.get().getResponseBody()
    }
}
