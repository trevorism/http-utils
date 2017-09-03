package com.trevorism.http.util

import org.junit.Test

/**
 * @author trevor.brooks
 */
class CleanUrlTest {

    @Test
    void testStartWithHttp() {
        assert "http://localhost" == com.trevorism.http.util.CleanUrl.startWithHttp("http://localhost")
    }

    @Test
    void testStartWitNoHttp() {
        assert "http://localhost" == com.trevorism.http.util.CleanUrl.startWithHttp("localhost")
    }
}
