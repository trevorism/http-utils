package com.trevorism.http.headers

import com.trevorism.http.BlankHttpClient
import com.trevorism.http.HeadersHttpResponse
import com.trevorism.http.HttpClientBase
import com.trevorism.http.util.HeadersHttpClientResponseHandler
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient
import org.junit.Before
import org.junit.Test

/**
 * @author tbrooks
 */
class HeadersBlankHttpClientTest {

    private HttpClientBase client

    @Before
    void setup(){
        client = new BlankHttpClient()
    }

    @Test
    void testGetMediaType() {
        assert client.getMediaType() == "text/plain"
    }



}
