package app.dao;

public class ResultEntity {
    double result;

    public ResultEntity(double result) {
        this.result = result;
    }

    public String getResult() {
        return "Result of operation is " + this.result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
