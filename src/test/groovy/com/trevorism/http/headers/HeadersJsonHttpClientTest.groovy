package com.trevorism.http.headers

import com.trevorism.http.BlankHttpClient
import com.trevorism.http.HttpClientBase
import com.trevorism.http.JsonHttpClient
import org.junit.Before
import org.junit.Test

/**
 * @author tbrooks
 */
class HeadersJsonHttpClientTest {

    private HttpClientBase client

    @Before
    void setup(){
        client = new JsonHttpClient()
    }

    @Test
    void testGetMediaType() {
        assert "application/json" == client.getMediaType()
    }

}
