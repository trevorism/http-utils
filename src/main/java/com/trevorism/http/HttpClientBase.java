package com.trevorism.http;

import com.trevorism.http.util.CleanUrl;
import com.trevorism.http.util.HeadersHttpClientResponseHandler;
import com.trevorism.http.util.InvalidRequestException;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author trevor.brooks
 */
public abstract class HttpClientBase implements HttpClient {

    protected CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * HTTP GET
     *
     * @param url The url to GET
     * @return response content as a string
     */
    @Override
    public String get(String url) {
        return get(url, new HashMap<>()).getValue();
    }

    @Override
    public HeadersHttpResponse get(String url, Map<String, String> headers) {
        return requestData(new HttpGet(CleanUrl.startWithHttps(url)), headers);
    }

    /**
     * HTTP POST
     *
     * @param url        The url to POST
     * @param serialized The request content as a string
     * @return response content as a string
     */
    @Override
    public String post(String url, String serialized) {
        return post(url, serialized, new HashMap<>()).getValue();
    }

    @Override
    public HeadersHttpResponse post(String url, String serialized, Map<String, String> headers) {
        return requestData(new HttpPost(CleanUrl.startWithHttps(url)), serialized, headers);
    }

    /**
     * HTTP PUT
     *
     * @param url        The url to PUT
     * @param serialized The request content as a string
     * @return response content as a string
     */
    @Override
    public String put(String url, String serialized) {
        return put(url, serialized, new HashMap<>()).getValue();
    }

    @Override
    public HeadersHttpResponse put(String url, String serialized, Map<String, String> headers) {
        return requestData(new HttpPut(CleanUrl.startWithHttps(url)), serialized, headers);
    }

    /**
     * Performs an HTTP PATCH
     *
     * @param url        The url to PATCH
     * @param serialized The serialized item to PATCH
     * @return The string content of the response
     */
    @Override
    public String patch(String url, String serialized) {
        return patch(url, serialized, new HashMap<>()).getValue();
    }

    @Override
    public HeadersHttpResponse patch(String url, String serialized, Map<String, String> headers) {
        return requestData(new HttpPatch(CleanUrl.startWithHttps(url)), serialized, headers);
    }

    /**
     * HTTP DELETE
     *
     * @param url The url to DELETE
     * @return response content as a string
     */
    @Override
    public String delete(final String url) {
        return delete(url, new HashMap<>()).getValue();
    }

    @Override
    public HeadersHttpResponse delete(String url, Map<String, String> headers) {
        return requestData(new HttpDelete(CleanUrl.startWithHttps(url)), headers);
    }

    protected abstract String getMediaType();

    private HeadersHttpResponse requestData(HttpUriRequestBase requestType, Map<String,String> headers) {
        try {
            for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
                requestType.setHeader(headerEntry.getKey(), headerEntry.getValue());
            }
            return httpClient.execute(requestType, new HeadersHttpClientResponseHandler());
        } catch (Exception e) {
            throw new InvalidRequestException(e);
        }
    }

    private HeadersHttpResponse requestData(HttpUriRequestBase requestType, String input, Map<String,String> headers) {
        try {
            requestType.setEntity(new StringEntity(input, ContentType.create(getMediaType())));
            for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
                requestType.setHeader(headerEntry.getKey(), headerEntry.getValue());
            }
            return httpClient.execute(requestType, new HeadersHttpClientResponseHandler());
        } catch (Exception e) {
            throw new InvalidRequestException(e);
        }
    }
}
