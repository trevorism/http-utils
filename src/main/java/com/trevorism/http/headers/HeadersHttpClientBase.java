package com.trevorism.http.headers;

import com.trevorism.http.util.CleanUrl;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author trevor.brooks
 */
public abstract class HeadersHttpClientBase implements HeadersHttpClient {

    protected CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * HTTP GET
     * @param url The url to GET
     * @param headers The HTTP headers to send with the request
     * @return response content as a string
     */
    @Override
    public CloseableHttpResponse get(String url, Map<String,String> headers) {
        return requestData(new HttpGet(CleanUrl.startWithHttps(url)), headers);
    }

    /**
     * HTTP POST
     * @param url The url to POST
     * @param serialized The request content as a string
     * @param headers The HTTP headers to send with the request
     * @return response content as a string
     */
    @Override
    public CloseableHttpResponse post(String url, String serialized, Map<String,String> headers) {
        return requestData(new HttpPost(CleanUrl.startWithHttps(url)), serialized, headers);
    }

    /**
     * HTTP PUT
     * @param url The url to PUT
     * @param serialized The request content as a string
     * @param headers The HTTP headers to send with the request
     * @return response content as a string
     */
    @Override
    public CloseableHttpResponse put(String url, String serialized, Map<String,String> headers) {
        return requestData(new HttpPut(CleanUrl.startWithHttps(url)), serialized, headers);
    }

    /**
     * HTTP PATCH
     * @param url The url to PATCH
     * @param serialized The request content as a string
     * @param headers The HTTP headers to send with the request
     * @return response content as a string
     */
    @Override
    public CloseableHttpResponse patch(String url, String serialized, Map<String,String> headers) {
        return requestData(new HttpPatch(CleanUrl.startWithHttps(url)), serialized, headers);
    }

    /**
     * HTTP DELETE
     * @param url The url to DELETE
     * @param headers The HTTP headers to send with the request
     * @return response content as a string
     */
    @Override
    public CloseableHttpResponse delete(final String url, Map<String,String> headers) {
        return requestData(new HttpDelete(CleanUrl.startWithHttps(url)), headers);
    }

    protected abstract String getMediaType();

    private CloseableHttpResponse requestData(HttpRequestBase requestType, Map<String,String> headers) {
        try
        {
            setHeaders(requestType, headers);
            return httpClient.execute(requestType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private CloseableHttpResponse requestData(HttpEntityEnclosingRequestBase requestType, String input, Map<String,String> headers) {

        try
        {
            setEntity(requestType, input);
            setHeaders(requestType, headers);
            return httpClient.execute(requestType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void setHeaders(HttpRequestBase requestType, Map<String, String> headers) {
        if(headers != null) {
            for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
                requestType.setHeader(headerEntry.getKey(), headerEntry.getValue());
            }
        }
    }

    private void setEntity(HttpEntityEnclosingRequestBase requestType, String input) throws UnsupportedEncodingException {
        StringEntity se = new StringEntity(input);
        if(getMediaType() != null) {
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, getMediaType()));
        }
        requestType.setEntity(se);
    }
}
