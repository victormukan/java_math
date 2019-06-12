package com.sofia.web.rest;

import com.google.gson.GsonBuilder;
import com.sofia.bussinessobj.HistoryBO;
import com.sofia.bussinessobj.MathOperationBO;
import com.sofia.util.Converter;
import com.sofia.util.ErrorResponse;
import com.sofia.util.GsonLocalDateTimeConverter;
import com.sofia.model.ResultEntity;
import com.google.gson.Gson;
import com.sofia.model.MathOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class Controller {
    private static final Gson converter = Converter.getConverter();
    HistoryBO history = new HistoryBO();

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
            return new ResponseEntity<>(converter.toJson(history.getHistory()), HttpStatus.OK);
        }
    }

    @PostMapping(path="/math", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> calculate(@RequestBody MathOperation mathOperation) {
        MathOperationBO math = new MathOperationBO();
        Double result = math.doOperation(mathOperation);
        history.addRecord(mathOperation, result);
        return new ResponseEntity<>(converter.toJson(new ResultEntity(result)), HttpStatus.OK);
    }

}
