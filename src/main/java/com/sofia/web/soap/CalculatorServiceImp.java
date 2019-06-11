package com.sofia.web.soap;

import com.sofia.bussinessobj.HistoryBO;
import com.sofia.bussinessobj.MathOperationBO;
import com.sofia.model.HistoryRecord;
import com.sofia.model.MathOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.sofia.web.soap.CalculatorService")
public class CalculatorServiceImp implements CalculatorService{
    private static Logger LOG = LogManager.getLogger(CalculatorServiceImp.class);


    @Override
    public Double doOperation(MathOperation mathOperation) {
        LOG.info("Doing operation!!!");
        MathOperationBO operation = new MathOperationBO();
        return operation.doOperation(mathOperation);
    }

    @Override
    public List<HistoryRecord> getHistory() {
        LOG.info("Getting ALL history");
        HistoryBO allHistory = new HistoryBO();
        return allHistory.getHistory();
    }

    @Override
    public List<HistoryRecord> getHistoryByDate(String limit) {
        LOG.info("Getting specific history with limit " + limit);
        HistoryBO specificHistory = new HistoryBO();
        return specificHistory.getHistoryByDate(limit);
    }
}
