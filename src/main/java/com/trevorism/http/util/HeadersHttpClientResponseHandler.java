package com.trevorism.http.util;

import com.trevorism.http.HeadersHttpResponse;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.impl.classic.AbstractHttpClientResponseHandler;
import org.apache.hc.core5.annotation.Contract;
import org.apache.hc.core5.annotation.ThreadingBehavior;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Contract(threading = ThreadingBehavior.STATELESS)
public class HeadersHttpClientResponseHandler extends AbstractHttpClientResponseHandler<HeadersHttpResponse> {

    private Map<String,String> headers = new HashMap<>();
    private int statusCode;

    /**
     * Returns the entity as a body as a String.
     */
    @Override
    public HeadersHttpResponse handleEntity(final HttpEntity entity) throws IOException {
        try {
            String value = EntityUtils.toString(entity);
            return new HeadersHttpResponse(value, headers, statusCode);
        } catch (final ParseException ex) {
            throw new ClientProtocolException(ex);
        }
    }

    @Override
    public HeadersHttpResponse handleResponse(final ClassicHttpResponse response) throws IOException {
        this.statusCode = response.getCode();
        final HttpEntity entity = response.getEntity();

        if (response.getCode() >= HttpStatus.SC_REDIRECTION) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(response.getCode(), response.getReasonPhrase());
        }

        for (Header header : response.getHeaders()) {
            headers.put(header.getName(), header.getValue());
        }
        return entity == null ? new HeadersHttpResponse(null, headers) : handleEntity(entity);
    }

}
