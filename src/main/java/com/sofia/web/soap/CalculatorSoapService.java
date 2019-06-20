package com.sofia.web.soap;

import com.sofia.entity.HistoryRecord;
import com.sofia.dto.MathOperation;

import javax.jws.WebService;
import java.util.List;

@WebService
interface CalculatorSoapService {
    Double doOperation(MathOperation mathOperation);

    List<HistoryRecord> getHistory();

    List<HistoryRecord> getHistoryByDate(String limit);
}
