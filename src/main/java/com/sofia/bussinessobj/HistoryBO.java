package com.sofia.bussinessobj;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sofia.model.HistoryRecord;
import com.sofia.model.MathOperation;
import com.sofia.util.date.Converter;
import com.sofia.util.date.HistoryDateParser;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryBO {
    private List<HistoryRecord> requestsHistory = new ArrayList<>();
    private Gson converter = Converter.getConverter();

    public HistoryBO() {
        try {
            String text = new String(Files.readAllBytes(
                    Paths.get(System.getProperty("user.dir") +
                    "\\src\\main\\resources\\history.json")),
                    StandardCharsets.UTF_8);

            Type parseType = new TypeToken<ArrayList<HistoryRecord>>(){}.getType();


            requestsHistory = converter.fromJson(text, parseType);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void addRecord(MathOperation operation, Double result) {
        requestsHistory.add(new HistoryRecord(operation, result));

        try (FileWriter writer = new FileWriter(System.getProperty("user.dir") +
                "\\src\\main\\resources\\history.json")){
            String data = converter.toJson(requestsHistory);
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<HistoryRecord> getHistory() {
        return requestsHistory;
    }


    public List<HistoryRecord> getHistoryByDate(String limit) {
        return requestsHistory.stream()
                .filter(i -> i.getRequestTime().isAfter(HistoryDateParser.getMinSatisfyingDate(limit)))
                .collect(Collectors.toList());
    }
}
