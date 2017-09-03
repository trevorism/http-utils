package com.trevorism.http.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author tbrooks
 */
public class ResponseUtils {

    public static String getEntity(CloseableHttpResponse response){
        try {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return result;
        }catch (IOException ie){
            throw new RuntimeException(ie);
        }
    }

    public static void closeSilently(CloseableHttpResponse response){
        try {
            response.close();
        }
        catch(Exception ignored){}
    }
}
