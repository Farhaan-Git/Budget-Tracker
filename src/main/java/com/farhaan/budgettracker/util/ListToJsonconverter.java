package com.farhaan.budgettracker.util;

import com.farhaan.budgettracker.Dto.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ListToJsonconverter {
    private static final ObjectMapper objectMapper  = new ObjectMapper();
    public static String
    convertToString(List<Item> stringDoubleMap) {
        try {
            return objectMapper.writeValueAsString(stringDoubleMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Item> convertToJson(String s) {
        try {
            return objectMapper.readValue(s, new TypeReference<List<Item>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
