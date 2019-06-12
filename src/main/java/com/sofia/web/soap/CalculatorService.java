package com.sofia.web.soap;

import com.sofia.model.HistoryRecord;
import com.sofia.model.MathOperation;

import javax.jws.WebService;
import java.util.List;

@WebService
interface CalculatorService {
    Double doOperation(MathOperation mathOperation);

    List<HistoryRecord> getHistory();

    List<HistoryRecord> getHistoryByDate(String limit);
}
