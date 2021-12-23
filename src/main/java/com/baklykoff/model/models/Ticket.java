package com.baklykoff.model.models;

import com.baklykoff.model.models.annotation.Column;
import com.baklykoff.model.models.annotation.PrimaryKey;
import com.baklykoff.model.models.annotation.Table;
import lombok.Data;

@Table(name = "ticket")
@Data
public class Ticket extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "is_vip")
    private Integer isVip;

    @Column(name = "price")
    private Float price;

    @Column(name = "park_attraction_id")
    private Integer parkAttractionId;
}
