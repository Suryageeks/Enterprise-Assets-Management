package com.eam.Fixed.Assets.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Applogger {
    private static final Logger logger = LoggerFactory.getLogger(Applogger.class);

    private Applogger() {}

    public static void logRequest(String http,String uri,int status,long time,String response) {
        logger.info("HTTP {} {} | Status: {} | Response: {} | Time: {}",http,uri,status,response,time);
    }

    public static void logError(String http,String uri,int status,long time,Exception e) {
        logger.error("HTTP {} {} | Status: {} | Time: {} | Exception Occurred",http,uri,status,time);
        logger.error("Exception: ",e);
    }
}
