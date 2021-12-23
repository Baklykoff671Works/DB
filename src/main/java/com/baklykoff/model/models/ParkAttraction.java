package com.baklykoff.model.models;

import com.baklykoff.model.models.annotation.Column;
import com.baklykoff.model.models.annotation.PrimaryKey;
import com.baklykoff.model.models.annotation.Table;
import lombok.Data;


@Table(name = "park_attraction")
@Data
public class ParkAttraction extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "park_id")
    private Integer parkId;

    @Column(name = "attraction_id")
    private Integer attractionId;

}
