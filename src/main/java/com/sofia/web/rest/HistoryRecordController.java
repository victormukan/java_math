//package com.sofia.web.rest;
//
//import com.google.gson.Gson;
//import com.sofia.repository.HistoryRecordRepository;
//import com.sofia.util.date.Converter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping({"/api"})
//public class HistoryRecordController {
//
//    @Autowired
//    HistoryRecordRepository historyRepository;
//
//    private static final Gson converter = Converter.getConverter();
//
//    @GetMapping(path="/history", produces= MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody ResponseEntity<String> getHistory() {
//        return new ResponseEntity<>(converter.toJson(historyRepository.findAll()), HttpStatus.OK);
//    }
//}
