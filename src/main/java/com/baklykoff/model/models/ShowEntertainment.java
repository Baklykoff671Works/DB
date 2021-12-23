package com.baklykoff.model.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="show_entertainment", schema="mydb")
@Data
public class ShowEntertainment extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "park_id", referencedColumnName = "id", nullable = false)
    private Park parkId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowEntertainment that = (ShowEntertainment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(parkId, that.parkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, parkId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-45s | %-20s |", id, description,parkId);
    }
}
