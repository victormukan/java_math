package com.sofia.web.soap;

import com.sofia.service.CalculatorService;
import com.sofia.service.HistoryService;
import com.sofia.entity.HistoryRecord;
import com.sofia.dto.MathOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.sofia.web.soap.CalculatorSoapService")
public class CalculatorSoapServiceImp implements CalculatorSoapService {
    private static Logger LOG = LogManager.getLogger(CalculatorSoapServiceImp.class);

    @Autowired
    private HistoryService history;

    @Autowired
    private CalculatorService calculator;

    @Override
    public Double doOperation(MathOperation mathOperation) {
        LOG.info("Doing operation!!!");
        return calculator.doOperation(mathOperation);
    }

    @Override
    public List<HistoryRecord> getHistory() {
        LOG.info("Getting ALL history");
        return history.getHistory();
    }

    @Override
    public List<HistoryRecord> getHistoryByDate(String limit) {
        LOG.info("Getting specific history with limit " + limit);
        return history.getHistoryByDate(limit);
    }
}
