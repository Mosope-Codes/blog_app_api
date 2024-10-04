package com.mosope.blogApp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseUtil {
    public static Map<String, Object> createSuceessResponse(String message, Object data) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", "true");
        response.put("message", message);
        if(data != null){
            response.put("data", data);
        }
        return response;
    }

    public static Map<String, Object> createSuceessResponse(String message) {
        return createSuceessResponse(message, null);
    }

    public static Map<String, Object> createErrorResponse(String message, Object error) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", "false");
        response.put("message", message);
        if(error != null){
            response.put("error", error);
        }
        return response;
    }

    public static Map<String, Object> createErrorResponse(String message) {
            return createErrorResponse(message, null);
    }
}
