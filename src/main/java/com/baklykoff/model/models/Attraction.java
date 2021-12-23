package com.baklykoff.model.models;

import com.baklykoff.model.models.annotation.Column;
import com.baklykoff.model.models.annotation.PrimaryKey;
import com.baklykoff.model.models.annotation.Table;
import lombok.Data;

@Table(name = "attraction")
@Data
public class Attraction extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_visitors")
    private Integer maxVisitors;

    @Column(name = "min_permision")
    private Integer minPermision;

    @Column(name = "has_option_vip")
    private Integer hasOptionVip;

}
