package com.trevorism.http

import org.junit.Test

/**
 * @author trevor.brooks
 */
class XmlHttpClientTest {

    @Test
    void testGetMediaType() {
        assert "text/xml" == new XmlHttpClient().getMediaType()
    }

    @Test
    void testXml(){
        String url = "https://endpoint-tester.testing.trevorism.com/api/xml"
        def client = new XmlHttpClient()

        String response = client.get(url)
        assert "hello xml" == response
    }

    @Test(expected = RuntimeException)
    void testErrorGet(){
        String url = "bzzzzzz"
        def client = new XmlHttpClient()

        client.get(url)
    }

    @Test(expected = RuntimeException)
    void testErrorPost(){
        String url = "bzzzzzz"
        def client = new XmlHttpClient()

        client.post(url,"<xml>test</xml>")

    }
}
