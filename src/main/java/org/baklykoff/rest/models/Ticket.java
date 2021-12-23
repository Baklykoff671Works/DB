package org.baklykoff.rest.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="ticket", schema="mydb")
@Data
public class Ticket extends GeneralModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "expiration_date")
    private Date expirationDate;

    @Basic
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Column(name = "is_vip")
    @NotNull(message = "Missing isVip")
    @Min(0)
    @Max(1)
    private Integer isVip;

    @Basic
    @Column(name = "price")
    @NotNull(message = "Missing price")
    @Min(1)
    @Max(9999999)
    private Float price;

    @ManyToOne
    @JoinColumn(name = "park_attraction_id", referencedColumnName = "id", nullable = false)
    private ParkAttraction parkAttractionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(expirationDate, ticket.expirationDate) &&
                Objects.equals(startDate, ticket.startDate) &&
                Objects.equals(isVip, ticket.isVip) &&
                Objects.equals(price, ticket.price) &&
                Objects.equals(parkAttractionId, ticket.parkAttractionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expirationDate, startDate, isVip, price, parkAttractionId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s | %-20s |",id, expirationDate, startDate, isVip, price, parkAttractionId);
    }


}