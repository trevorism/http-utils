package com.trevorism.http

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HttpClientBaseTest {

    private HttpClientBase client

    @BeforeEach
    void setup(){
        client = new HttpClientBase() {
            @Override
            protected String getMediaType() {
                "application/json"
            }
        }
        client.httpClient = [execute: {x,y -> new HeadersHttpResponse("hello", [:])}] as CloseableHttpClient
    }

    @Test
    void testGet() {
        assert "hello" == client.get("https://endpoint-tester.testing.trevorism.com/api/json")

    }

    @Test
    void testGetHeaders() {
        assert "hello" == client.get("https://endpoint-tester.testing.trevorism.com/api/json",[:]).getValue()
    }

    @Test
    void testPost() {
        assert "hello" == client.post("https://endpoint-tester.testing.trevorism.com/api/json", "{}")
    }

    @Test
    void testPostHeaders() {
        assert "hello" == client.post("https://endpoint-tester.testing.trevorism.com/api/json", "{}", [:]).getValue()
    }

    @Test
    void testPut() {
        assert "hello" == client.put("https://endpoint-tester.testing.trevorism.com/api/json", "{}")
    }

    @Test
    void testPutHeaders() {
        assert "hello" == client.put("https://endpoint-tester.testing.trevorism.com/api/json", "{}", [:]).getValue()
    }

    @Test
    void testPatch() {
        assert "hello" == client.patch("https://endpoint-tester.testing.trevorism.com/api/json", "{}")
    }

    @Test
    void testPatchHeaders() {
        assert "hello" == client.patch("https://endpoint-tester.testing.trevorism.com/api/json", "{}", [:]).getValue()
    }

    @Test
    void testDelete() {
        assert "hello" == client.delete("https://endpoint-tester.testing.trevorism.com/api/json")
    }

    @Test
    void testDeleteHeaders() {
        assert "hello" == client.delete("https://endpoint-tester.testing.trevorism.com/api/json",[:]).getValue()
    }
}
