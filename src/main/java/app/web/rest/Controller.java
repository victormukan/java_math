package app.web.rest;

import app.dao.OperationType;
import app.dao.ResultEntity;
import com.google.gson.Gson;
import app.dao.MathOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    private static final Gson converter = new Gson();

    @GetMapping(path="/hello")
    public @ResponseBody ResponseEntity<String> hello() {
        return new ResponseEntity<>("hi", HttpStatus.OK);
    }

    @PostMapping(path="/math", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> calculate(@RequestBody MathOperation mathOperation) {
        Double result = null;
        switch(mathOperation.getOperationType()) {
            case ADD:
                result = mathOperation.getFirstNumber() + mathOperation.getSecondNumber();
                break;
            case DEVIDE:
                result = mathOperation.getFirstNumber() / mathOperation.getSecondNumber();
                break;
        }
        return new ResponseEntity<>(converter.toJson(new ResultEntity(result)), HttpStatus.OK);
    }

}
