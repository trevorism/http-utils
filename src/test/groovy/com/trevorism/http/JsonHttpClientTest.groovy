package com.trevorism.http

import com.trevorism.http.util.InvalidRequestException
import org.junit.Test

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
        String url = "https://endpoint-tester-dot-trevorism-testing.appspot.com/api/json"
        def client = new JsonHttpClient()

        assert "hello json" == client.get(url)
        assert "{}" == client.post(url, "{}")
        assert "{}" == client.put(url, "{}")
        assert "delete json" == client.delete(url)
    }

    @Test(expected = InvalidRequestException)
    void testInvalidJson(){
        String url = "https://endpoint-tester-dot-trevorism-testing.appspot.com/api/json/fail"
        def client = new JsonHttpClient()

        String response = client.get(url)
        assert response.contains("404")
    }
}
