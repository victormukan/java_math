package com.sofia.web.soap;

import com.sofia.bo.HistoryBO;
import com.sofia.bo.MathOperationBO;
import com.sofia.entity.HistoryRecord;
import com.sofia.model.MathOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.sofia.web.soap.CalculatorService")
public class CalculatorServiceImp implements CalculatorService{
    private static Logger LOG = LogManager.getLogger(CalculatorServiceImp.class);

    @Autowired
    HistoryBO history;

    @Override
    public Double doOperation(MathOperation mathOperation) {
        LOG.info("Doing operation!!!");
        MathOperationBO operation = new MathOperationBO();
        return operation.doOperation(mathOperation);
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
