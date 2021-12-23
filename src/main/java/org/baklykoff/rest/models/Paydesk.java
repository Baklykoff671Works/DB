package org.baklykoff.rest.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.sql.Date;

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
    @NotNull(message = "Missing hasTicket")
    @Min(0)
    @Max(1)
    private Integer hasTicket;

    @ManyToOne
    @JoinColumn(name = "park_id", referencedColumnName = "id", nullable = false)
    private Park parkId;


    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-40s |", id, attractionId, hasTicket, parkId);
    }


}
