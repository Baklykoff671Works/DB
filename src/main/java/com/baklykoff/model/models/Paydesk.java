package com.baklykoff.model.models;

import com.baklykoff.model.models.annotation.Column;
import com.baklykoff.model.models.annotation.PrimaryKey;
import com.baklykoff.model.models.annotation.Table;
import lombok.Data;

@Table(name = "paydesk")
@Data
public class Paydesk extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "attraction_id")
    private Integer attractionId;

    @Column(name = "has_ticket")
    private Integer hasTicket;

    @Column(name = "park_id")
    private Integer parkId;


}
