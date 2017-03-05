package com.games.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by prakash.vijay on 24/08/16.
 */
public class JsonConverter {

    static private ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        objectMapper.enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
    }

    static public String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    static public <T> T fromJson(String jsonString, Class<T> type) throws IOException {
        return objectMapper.readValue(jsonString,type);
    }

}
