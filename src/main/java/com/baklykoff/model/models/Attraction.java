package com.baklykoff.model.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="attraction", schema="mydb")
@Data
public class Attraction extends GeneralModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "max_visitors")
    private Integer maxVisitors;

    @Basic
    @Column(name = "min_permision")
    private Integer minPermision;

    @Basic
    @Column(name = "has_option_vip")
    private Integer hasOptionVip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(maxVisitors, that.maxVisitors) &&
                Objects.equals(minPermision, that.minPermision) &&
                Objects.equals(hasOptionVip, that.hasOptionVip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maxVisitors, minPermision, hasOptionVip);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-40s | %-20s | %-20s | %-20s |",id, name, maxVisitors, minPermision, hasOptionVip);
    }
}