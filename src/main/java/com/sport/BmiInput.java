package com.sport;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BmiInput {

    private Gender gender;
    private Double age;
    private Double weight;
    private Double height;
    private Double bmi;
    private Double bmr;
    private Double bmr2;
    private Status status;
    private String show;
    private BmiIndicator bmiIndicator;
    private String bmiIndicatorMessage;
    private String result;
}
