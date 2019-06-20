package com.sofia.web.rest;

import com.sofia.service.CalculatorService;
import com.sofia.service.HistoryService;
import com.sofia.entity.HistoryRecord;
import com.sofia.util.date.Converter;
import com.sofia.dto.ErrorResponse;
import com.google.gson.Gson;
import com.sofia.dto.MathOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api"})
public class Controller {

    private static final Gson converter = Converter.getConverter();

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CalculatorService calculator;


    @GetMapping(path="/historyService", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getHistory(@RequestParam(required = false) String limit) {
        if (limit != null) {
            try {
                return new ResponseEntity<>(converter.toJson(historyService.getHistoryByDate(limit)), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(converter.toJson(new ErrorResponse("Error in limit param")), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            List<HistoryRecord> result = historyService.getHistory();
            return new ResponseEntity<>(converter.toJson(result), HttpStatus.OK);
        }
    }

    @GetMapping(path="/historyService/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getHistoryRecordById(@PathVariable int id) {
        HistoryRecord result = historyService.getHistoryById(id);
        if (result != null) {
            return new ResponseEntity<>(converter.toJson(result), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("HistoryRecord not found with id=" + id, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path="/math", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> calculate(@RequestBody MathOperation mathOperation) {
        Double result = calculator.doOperation(mathOperation);
        HistoryRecord insertedRecord = historyService.addRecord(mathOperation, result);
        return new ResponseEntity<>(converter.toJson(insertedRecord), HttpStatus.OK);
    }

}
