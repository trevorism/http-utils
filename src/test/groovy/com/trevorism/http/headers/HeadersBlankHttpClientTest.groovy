package com.trevorism.http.headers

import com.trevorism.http.BlankHttpClient
import com.trevorism.http.HttpClientBase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * @author tbrooks
 */
class HeadersBlankHttpClientTest {

    private HttpClientBase client

    @BeforeEach
    void setup(){
        client = new BlankHttpClient()
    }

    @Test
    void testGetMediaType() {
        assert client.getMediaType() == "text/plain"
    }



}
