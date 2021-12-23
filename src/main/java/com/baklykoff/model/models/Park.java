package com.baklykoff.model.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="park", schema="mydb")
@Data
public class Park extends GeneralModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "visitors")
    private Integer visitors;

    @Basic
    @Column(name = "location")
    private String location;

    @Basic
    @Column(name = "max_visitors")
    private Integer maxVisitors;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Park park = (Park) o;
        return Objects.equals(id, park.id) &&
                Objects.equals(name, park.name) &&
                Objects.equals(visitors, park.visitors) &&
                Objects.equals(location, park.location) &&
                Objects.equals(maxVisitors, park.maxVisitors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, visitors, location, maxVisitors);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |",id,name,visitors,location,maxVisitors);
    }
}
