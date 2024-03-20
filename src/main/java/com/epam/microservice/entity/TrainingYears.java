package com.epam.microservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class TrainingYears {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String yearNumber;
    @OneToMany(fetch = FetchType.EAGER)
    private List<TrainingMonth> months;
}
