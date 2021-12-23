package com.baklykoff.model.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="park_attraction", schema="mydb")
@Data
public class ParkAttraction extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "park_id", referencedColumnName = "id", nullable = false)
    private Park parkId;

    @ManyToOne
    @JoinColumn(name = "attraction_id", referencedColumnName = "id", nullable = false)
    private Attraction attractionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkAttraction that = (ParkAttraction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(parkId, that.parkId) &&
                Objects.equals(attractionId, that.attractionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parkId, attractionId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,parkId, attractionId);
    }
}
