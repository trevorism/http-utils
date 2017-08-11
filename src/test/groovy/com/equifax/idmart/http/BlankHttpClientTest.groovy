package com.equifax.idmart.http

import org.junit.Test

/**
 * @author trevor.brooks
 */
class BlankHttpClientTest {

    @Test
    void testGetMediaType() {
        assert !(new BlankHttpClient().getMediaType())
    }

    @Test
    void testBlank(){
        String url = "https://ixips-waiter-eastus2-prod.azurewebsites.net/api/waiter/10"
        def client = new BlankHttpClient()

        String response = client.get(url)
        assert "true" == response
    }
}
