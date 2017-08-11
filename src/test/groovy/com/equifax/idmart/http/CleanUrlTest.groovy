package com.equifax.idmart.http

import org.junit.Test

/**
 * @author trevor.brooks
 */
class CleanUrlTest {

    @Test
    void testStartWithHttp() {
        assert "http://localhost" == CleanUrl.startWithHttp("http://localhost")
    }

    @Test
    void testStartWitNoHttp() {
        assert "http://localhost" == CleanUrl.startWithHttp("localhost")
    }
}
