package com.baklykoff.model.models;

import com.baklykoff.model.models.annotation.Column;
import com.baklykoff.model.models.annotation.PrimaryKey;
import com.baklykoff.model.models.annotation.Table;
import lombok.Data;


@Table(name = "visitor")
@Data
public class Visitor extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ticket_id")
    private Integer ticketId;

}
