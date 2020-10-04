package com.trevorism.http.util

import org.junit.Test

/**
 * @author trevor.brooks
 */
class CleanUrlTest {

    @Test
    void testStartWithHttp() {
        assert "http://localhost" == CleanUrl.startWithHttps("http://localhost")
    }

    @Test
    void testStartWitHttps() {
        assert "https://localhost" == CleanUrl.startWithHttps("https://localhost")
    }

    @Test
    void testStartWitNoHttp() {
        assert "https://localhost" == CleanUrl.startWithHttps("localhost")
    }
}
