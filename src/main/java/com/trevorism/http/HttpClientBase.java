package com.trevorism.http;

import com.trevorism.http.util.CleanUrl;
import com.trevorism.http.util.ResponseUtils;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;

/**
 * @author trevor.brooks
 */
public abstract class HttpClientBase implements HttpClient {

    private CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * HTTP GET
     * @param url The url to GET
     * @return response content as a string
     */
    @Override
    public String get(String url) {
        return requestData(new HttpGet(CleanUrl.startWithHttps(url)));
    }

    /**
     * HTTP POST
     * @param url The url to POST
     * @param serialized The request content as a string
     * @return response content as a string
     */
    @Override
    public String post(String url, String serialized) {
        return requestData(new HttpPost(CleanUrl.startWithHttps(url)), serialized);
    }

    /**
     * HTTP PUT
     * @param url The url to PUT
     * @param serialized The request content as a string
     * @return response content as a string
     */
    @Override
    public String put(String url, String serialized) {
        return requestData(new HttpPut(CleanUrl.startWithHttps(url)), serialized);
    }

    /**
     * HTTP DELETE
     * @param url The url to DELETE
     * @return response content as a string
     */
    @Override
    public String delete(final String url) {
        return requestData(new HttpDelete(CleanUrl.startWithHttps(url)));
    }

    protected abstract String getMediaType();

    private String requestData(HttpRequestBase requestType) {
        CloseableHttpResponse response = null;
        try
        {
            response = httpClient.execute(requestType);
            return ResponseUtils.getEntity(response);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            ResponseUtils.closeSilently(response);
        }
    }

    private String requestData(HttpEntityEnclosingRequestBase requestType, String input) {
        CloseableHttpResponse response = null;
        try
        {
            setEntity(requestType, input);
            response = httpClient.execute(requestType);
            return ResponseUtils.getEntity(response);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            ResponseUtils.closeSilently(response);
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
