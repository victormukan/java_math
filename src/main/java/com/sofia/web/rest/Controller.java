package com.sofia.web.rest;

import com.sofia.bussinessobj.HistoryBO;
import com.sofia.bussinessobj.MathOperationBO;
import com.sofia.model.ResultEntity;
import com.google.gson.Gson;
import com.sofia.model.MathOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private static final Gson converter = new Gson();

    @GetMapping(path="/history")
    public @ResponseBody ResponseEntity<String> hello() {
        return new ResponseEntity<>(converter.toJson(HistoryBO.getHistory()), HttpStatus.OK);
    }

    @PostMapping(path="/math", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> calculate(@RequestBody MathOperation mathOperation) {
        MathOperationBO math = new MathOperationBO();
        Double result = math.doOperation(mathOperation);
        HistoryBO.addRecord(mathOperation, result);
        return new ResponseEntity<>(converter.toJson(new ResultEntity(result)), HttpStatus.OK);
    }

}