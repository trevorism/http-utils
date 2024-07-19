package com.trevorism.http.headers

import com.trevorism.http.HttpClientBase
import com.trevorism.http.JsonHttpClient
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * @author tbrooks
 */
class HeadersJsonHttpClientTest {

    private HttpClientBase client

    @BeforeEach
    void setup(){
        client = new JsonHttpClient()
    }

    @Test
    void testGetMediaType() {
        assert "application/json" == client.getMediaType()
    }

}
