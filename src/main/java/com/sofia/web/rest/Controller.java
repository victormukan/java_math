package com.sofia.web.rest;

import com.sofia.bo.HistoryBO;
import com.sofia.bo.MathOperationBO;
import com.sofia.entity.HistoryRecord;
import com.sofia.util.date.Converter;
import com.sofia.util.exception.ErrorResponse;
import com.google.gson.Gson;
import com.sofia.model.MathOperation;
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
    HistoryBO history;

    @GetMapping(path="/history", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getHistory(@RequestParam(required = false) String limit) {
        if (limit != null) {
            try {
                return new ResponseEntity<>(converter.toJson(history.getHistoryByDate(limit)), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(converter.toJson(new ErrorResponse("Error in limit param")), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            List<HistoryRecord> result = history.getHistory();
            return new ResponseEntity<>(converter.toJson(result), HttpStatus.OK);
        }
    }

    @GetMapping(path="/history/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getHistoryRecordById(@PathVariable int id) {
        HistoryRecord result = history.getHistoryById(id);
        if (result != null) {
            return new ResponseEntity<>(converter.toJson(result), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("HistoryRecord not found with id=" + id, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path="/math", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> calculate(@RequestBody MathOperation mathOperation) {
        MathOperationBO math = new MathOperationBO();
        Double result = math.doOperation(mathOperation);
        HistoryRecord insertedRecord = history.addRecord(mathOperation, result);
        return new ResponseEntity<>(converter.toJson(insertedRecord), HttpStatus.OK);
    }

}
