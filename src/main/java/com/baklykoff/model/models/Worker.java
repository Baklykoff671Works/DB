package com.baklykoff.model.models;

import com.baklykoff.model.models.annotation.Column;
import com.baklykoff.model.models.annotation.PrimaryKey;
import com.baklykoff.model.models.annotation.Table;
import lombok.Data;


@Table(name = "worker")
@Data
public class Worker extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "passport_number")
    private Integer passportNumber;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "permision")
    private Integer permision;

    @Column(name = "park_id")
    private Integer parkId;
}
