package com.baklykoff.model.models;

import com.baklykoff.model.models.annotation.Column;
import com.baklykoff.model.models.annotation.PrimaryKey;
import com.baklykoff.model.models.annotation.Table;
import lombok.Data;

@Table(name = "show_entertainment")
@Data
public class ShowEntertainment extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "park_id")
    private Integer parkId;

}
