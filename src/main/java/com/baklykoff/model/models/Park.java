package com.baklykoff.model.models;

import com.baklykoff.model.models.annotation.Column;
import com.baklykoff.model.models.annotation.PrimaryKey;
import com.baklykoff.model.models.annotation.Table;

import lombok.Data;

@Table(name = "park")
@Data
public class Park extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "visitors")
    private Integer visitors;

    @Column(name = "location")
    private String location;

    @Column(name = "max_visitors")
    private Integer maxVisitors;
}
