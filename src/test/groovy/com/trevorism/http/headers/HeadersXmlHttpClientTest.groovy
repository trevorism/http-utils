package com.trevorism.http.headers

import com.trevorism.http.HttpClientBase
import com.trevorism.http.XmlHttpClient
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * @author tbrooks
 */
class HeadersXmlHttpClientTest {

    private HttpClientBase client

    @BeforeEach
    void setup(){
        client = new XmlHttpClient()
    }

    @Test
    void testGetMediaType() {
        assert "text/xml" == client.getMediaType()
    }

}
