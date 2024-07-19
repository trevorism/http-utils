package com.trevorism.http.async

import org.apache.hc.client5.http.async.methods.SimpleHttpResponse
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient
import org.apache.hc.core5.reactor.IOReactorStatus
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.util.concurrent.ExecutionException
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * @author trevor.brooks
 */
class AsyncJsonHttpClientTest {

    private AsyncJsonHttpClient client = new AsyncJsonHttpClient()
    private String url = "https://endpoint-tester.testing.trevorism.com/api/json"

    @BeforeEach
    void setup(){
        client.asyncHttpClient = [getStatus:{-> IOReactorStatus.ACTIVE}, doExecute: { u, v, w, x, y, z -> return new Future<SimpleHttpResponse>(){
            @Override
            boolean cancel(boolean mayInterruptIfRunning) {
                return false
            }

            @Override
            boolean isCancelled() {
                return false
            }

            @Override
            boolean isDone() {
                return false
            }

            @Override
            SimpleHttpResponse get() throws InterruptedException, ExecutionException {
                return SimpleHttpResponse.create(200, "{}")
            }

            @Override
            SimpleHttpResponse get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null
            }
        }}] as CloseableHttpAsyncClient
    }

    @Test
    void testGet() {
        Future<SimpleHttpResponse> future = client.get(url, new TestFutureCallback())
        assert "{}" == future.get().getBody().bodyText
    }

    @Test
    void testPost() {
        Future<SimpleHttpResponse> future = client.post(url, "{}", new TestFutureCallback())
        assert "{}" == future.get().getBody().bodyText
    }

    @Test
    void testPut() {
        Future<SimpleHttpResponse> future = client.put(url, "{}", new TestFutureCallback())
        assert "{}" == future.get().getBody().bodyText
    }

    @Test
    void testDelete() {
        Future<SimpleHttpResponse> future = client.delete(url, new TestFutureCallback())
        assert "{}" == future.get().getBody().bodyText
    }
}
