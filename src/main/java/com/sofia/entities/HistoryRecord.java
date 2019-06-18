package com.sofia.entities;

import com.sofia.model.MathOperation;
import com.sofia.model.OperationType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="history")
@Data
public class HistoryRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="firstNumber")
    private double firstNumber;

    @Column(name="secondNumber")
    private double secondNumber;

    private String mathOperation;

    private double result;

    private String requestTime;

}
