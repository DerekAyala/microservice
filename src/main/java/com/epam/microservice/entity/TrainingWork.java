package com.epam.microservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@ToString
public class TrainingWork {
    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean status;
    private List<TrainingYear> years;
}
