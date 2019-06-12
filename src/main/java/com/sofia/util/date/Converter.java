package com.sofia.util.date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sofia.util.date.GsonLocalDateTimeConverter;

import java.time.LocalDateTime;

public class Converter {
    private static final Gson converter = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeConverter())
            .create();

    public static Gson getConverter() {
        return converter;
    }
}
