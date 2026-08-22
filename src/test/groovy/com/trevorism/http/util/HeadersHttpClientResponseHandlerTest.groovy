package com.trevorism.http.util

import org.apache.hc.client5.http.HttpResponseException
import org.apache.hc.core5.http.ClassicHttpResponse
import org.apache.hc.core5.http.Header
import org.apache.hc.core5.http.HttpEntity
import org.apache.hc.core5.http.io.entity.StringEntity
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertThrows

class HeadersHttpClientResponseHandlerTest {

    @Test
    void testAFailureCarriesTheResponseBody() {
        ClassicHttpResponse response = errorResponse(400, "Bad Request",
                new StringEntity('{"message":"Domain acme.com is already in use"}'))

        HttpResponseBodyException e = assertThrows(HttpResponseBodyException) {
            new HeadersHttpClientResponseHandler().handleResponse(response)
        }

        assert e.statusCode == 400
        assert e.reasonPhrase == "Bad Request"
        assert e.responseBody == '{"message":"Domain acme.com is already in use"}'
    }

    @Test
    void testAFailureIsStillAnHttpResponseException() {
        ClassicHttpResponse response = errorResponse(404, "Not Found", new StringEntity("nope"))

        assertThrows(HttpResponseException) {
            new HeadersHttpClientResponseHandler().handleResponse(response)
        }
    }

    @Test
    void testAFailureWithoutAnEntityHasNoBody() {
        ClassicHttpResponse response = errorResponse(500, "Internal Server Error", null)

        HttpResponseBodyException e = assertThrows(HttpResponseBodyException) {
            new HeadersHttpClientResponseHandler().handleResponse(response)
        }

        assert e.responseBody == null
    }

    @Test
    void testASuccessfulResponseIsUnchanged() {
        ClassicHttpResponse response = errorResponse(200, "OK", new StringEntity('{"id":"req-1"}'))

        def result = new HeadersHttpClientResponseHandler().handleResponse(response)

        assert result.value == '{"id":"req-1"}'
        assert result.statusCode == 200
    }

    private static ClassicHttpResponse errorResponse(int code, String reason, HttpEntity entity) {
        return [
                getCode        : { code },
                getReasonPhrase: { reason },
                getEntity      : { entity },
                getHeaders     : { new Header[0] }
        ] as ClassicHttpResponse
    }
}
