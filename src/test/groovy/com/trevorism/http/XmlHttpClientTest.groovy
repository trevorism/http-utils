package com.trevorism.http

import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.assertThrows
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
        assert '<hello> xml </hello>' == response
    }

    @Test
    void testErrorGet(){
        String url = "bzzzzzz"
        def client = new XmlHttpClient()

        assertThrows(RuntimeException, () -> client.get(url))
    }

    @Test
    void testErrorPost(){
        String url = "bzzzzzz"
        def client = new XmlHttpClient()

        assertThrows(RuntimeException, () -> client.post(url,"<xml>test</xml>"))

    }
}
