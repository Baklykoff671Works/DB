package com.baklykoff.model.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "paydesk", schema = "mydb")
@Data
public class Paydesk extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "attraction_id", referencedColumnName = "id", nullable = false)
    private Attraction attractionId;

    @Basic
    @Column(name = "has_ticket")
    private Integer hasTicket;

    @ManyToOne
    @JoinColumn(name = "park_id", referencedColumnName = "id", nullable = false)
    private Park parkId;


    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-40s |", id, attractionId, hasTicket, parkId);
    }
}
