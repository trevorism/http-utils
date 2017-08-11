package com.equifax.idmart.http

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
        String url = "https://ixips-waiter-eastus2-prod.azurewebsites.net/api/waiter/10"
        def client = new JsonHttpClient()

        assert "true" == client.get(url)
        assert "true" == client.post(url, "{}")
        assert "true" == client.put(url, "{}")
        assert "true" == client.delete(url)
    }

    @Test
    void testInvalidJson(){
        String url = "https://ixips-waiter-eastus2-prod.azurewebsites.net/api/waiter/ggg"
        def client = new JsonHttpClient()

        String response = client.get(url)
        assert response.contains("\"statusCode\":500")
    }
}
