package com.trevorism.http

import org.junit.jupiter.api.Test

/**
 * @author trevor.brooks
 */
class BlankHttpClientTest {

    @Test
    void testGetMediaType() {
        assert new BlankHttpClient().getMediaType() == "text/plain"
    }

    @Test
    void testBlank(){
        String url = "https://endpoint-tester.testing.trevorism.com/api/nospec"
        def client = new BlankHttpClient()

        String response = client.get(url)
        assert "hello" == response
    }
}
