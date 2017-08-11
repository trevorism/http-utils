package com.trevorism.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author trevor.brooks
 */
public abstract class HttpClientBase implements HttpClient {

    private CloseableHttpClient httpClient = HttpClients.createDefault();

    @Override
    public String get(String url) {
        return requestData(new HttpGet(CleanUrl.startWithHttp(url)));
    }

    @Override
    public String post(String url, String serialized) {
        return requestData(new HttpPost(CleanUrl.startWithHttp(url)), serialized);
    }

    @Override
    public String put(String url, String serialized) {
        return requestData(new HttpPut(CleanUrl.startWithHttp(url)), serialized);
    }

    @Override
    public String delete(final String url) {
        return requestData(new HttpDelete(CleanUrl.startWithHttp(url)));
    }

    protected abstract String getMediaType();

    private String requestData(HttpRequestBase requestType) {
        CloseableHttpResponse response = null;
        try
        {
            response = httpClient.execute(requestType);
            return getResponseAsString(response);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                if (response != null)
                    response.close();
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }

    private String getResponseAsString(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        EntityUtils.consume(entity);
        return result;
    }

    private String requestData(HttpEntityEnclosingRequestBase requestType, String input) {
        CloseableHttpResponse response = null;
        try
        {
            setEntity(requestType, input);
            response = httpClient.execute(requestType);
            return getResponseAsString(response);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                if (response != null)
                    response.close();
            }catch (Exception ex){
                throw new RuntimeException(ex);
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
