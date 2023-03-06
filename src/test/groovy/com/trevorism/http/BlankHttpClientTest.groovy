package com.trevorism.http

import org.junit.Test

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
        String url = "https://endpoint-tester-dot-trevorism-testing.appspot.com/api/nospec"
        def client = new BlankHttpClient()

        String response = client.get(url)
        assert "hello" == response
    }
}
