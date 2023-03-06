package com.trevorism.http.headers

import com.trevorism.http.BlankHttpClient
import com.trevorism.http.HttpClientBase
import com.trevorism.http.XmlHttpClient
import org.junit.Before
import org.junit.Test

/**
 * @author tbrooks
 */
class HeadersXmlHttpClientTest {

    private HttpClientBase client

    @Before
    void setup(){
        client = new XmlHttpClient()
    }

    @Test
    void testGetMediaType() {
        assert "text/xml" == client.getMediaType()
    }

}
