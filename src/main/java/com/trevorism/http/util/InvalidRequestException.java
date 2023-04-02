package com.trevorism.http.util;

public class InvalidRequestException extends RuntimeException{

    private final int statusCode;

    public InvalidRequestException(Throwable e){
        super(e);
        this.statusCode = 500;
    }

    public InvalidRequestException(Throwable e, int statusCode){
        super(e);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
