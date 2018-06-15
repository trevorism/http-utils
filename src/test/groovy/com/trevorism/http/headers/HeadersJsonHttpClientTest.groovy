package com.trevorism.http.headers

import org.junit.Test

/**
 * @author tbrooks
 */
class HeadersJsonHttpClientTest {
    @Test
    void testGetMediaType() {
        assert "application/json" == new HeadersJsonHttpClient().getMediaType()
    }
}
