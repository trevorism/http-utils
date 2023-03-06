package com.trevorism.http.util;

public class InvalidRequestException extends RuntimeException{

    public InvalidRequestException(Throwable e){
        super(e);
    }
}
