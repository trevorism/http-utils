package com.trevorism.http

import com.trevorism.http.util.InvalidRequestException
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertThrows

/**
 * @author trevor.brooks
 */
class JsonHttpClientTest {

    @Test
    void testGetMediaType() {
        assert "application/json" == new JsonHttpClient().getMediaType()
    }

    @Test
    void testJson(){
        String url = "https://endpoint-tester.testing.trevorism.com/api/json"
        def client = new JsonHttpClient()

        assert '{"hello": "json"}' == client.get(url)
        assert "{}" == client.post(url, "{}")
        assert "{}" == client.put(url, "{}")
        assert '{"delete": "json"}' == client.delete(url)
    }

    @Test
    void testInvalidJson(){
        String url = "https://endpoint-tester.testing.trevorism.com/api/json/fail"
        def client = new JsonHttpClient()

        assertThrows(InvalidRequestException, () -> client.get(url))

    }
}
