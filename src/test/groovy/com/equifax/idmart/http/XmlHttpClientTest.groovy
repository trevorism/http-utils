package com.equifax.idmart.http

import org.junit.Test

/**
 * @author trevor.brooks
 */
class XmlHttpClientTest {

    @Test
    void testGetMediaType() {
        assert "application/xml" == new XmlHttpClient().getMediaType()
    }

    @Test
    void testXml(){
        String url = "https://ixips-waiter-eastus2-prod.azurewebsites.net/api/waiter/10"
        def client = new XmlHttpClient()

        String response = client.get(url)
        assert "true" == response
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
