package com.trevorism.http.async

import org.apache.hc.client5.http.async.methods.SimpleHttpResponse
import org.apache.hc.core5.concurrent.FutureCallback

class TestFutureCallback implements FutureCallback<SimpleHttpResponse> {

    @Override
    void completed(SimpleHttpResponse result) {
        assert result.code == 200
    }

    @Override
    void failed(Exception ex) {
        assert !ex
    }

    @Override
    void cancelled() {
        assert false
    }
}
