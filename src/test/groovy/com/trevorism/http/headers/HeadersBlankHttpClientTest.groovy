package com.trevorism.http.headers

import com.trevorism.http.util.ResponseUtils
import org.apache.http.HttpEntity
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.impl.client.CloseableHttpClient
import org.junit.Before
import org.junit.Test

/**
 * @author tbrooks
 */
class HeadersBlankHttpClientTest {

    private HeadersHttpClientBase client

    @Before
    void setup(){
        client = new HeadersBlankHttpClient()
        client.httpClient = [execute: {requestType -> createCloseableHttpResponse("{}")}] as CloseableHttpClient
    }

    @Test
    void testGetMediaType() {
        assert !client.getMediaType()
    }

    @Test
    void testGet(){
        def response = client.get("url", [:])
        String result = ResponseUtils.getEntity(response)
        assert result == "{}"
    }

    @Test
    void testPost(){
        def response = client.post("url", "{}", [:])
        String result = ResponseUtils.getEntity(response)
        assert result == "{}"
    }

    @Test
    void testPut(){
        def response = client.put("url", "{}", [:])
        String result = ResponseUtils.getEntity(response)
        assert result == "{}"
    }

    @Test
    void testDelete(){
        def response = client.delete("url", [:])
        String result = ResponseUtils.getEntity(response)
        assert result == "{}"
    }

    static CloseableHttpResponse createCloseableHttpResponse(String responseString){
        Closure getContentClosure = { -> new ByteArrayInputStream( responseString.getBytes() ) }
        Closure getContentLengthClosure = {->Long.valueOf(responseString.size())}
        HttpEntity entity = [getContentLength: getContentLengthClosure,getContentType: {return null},getContent: getContentClosure, isStreaming:{->true}] as HttpEntity
        CloseableHttpResponse response = [getEntity:{ -> entity}] as CloseableHttpResponse
        return response
    }

}
