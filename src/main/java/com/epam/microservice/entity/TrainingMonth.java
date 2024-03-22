package com.epam.microservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TrainingMonth {
    private String monthName;
    private Integer hours;
}
