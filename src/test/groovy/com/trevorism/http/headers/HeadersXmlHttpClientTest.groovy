package com.trevorism.http.headers

import org.junit.Test

/**
 * @author tbrooks
 */
class HeadersXmlHttpClientTest {

    @Test
    void testGetMediaType() {
        assert "application/xml" == new HeadersXmlHttpClient().getMediaType()
    }
}
