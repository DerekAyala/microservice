package com.epam.microservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TrainingYear {
    private String yearNumber;
    private List<TrainingMonth> months;
}
