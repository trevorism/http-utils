package com.trevorism.http.util;

import java.util.UUID;

/**
 * @author tbrooks
 */
public class CorrelationGenerator {

    public static String generate(){
        return UUID.randomUUID().toString();
    }
}
