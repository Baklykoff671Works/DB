package com.baklykoff.model.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="worker", schema="mydb")
@Data
public class Worker extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "position")
    private String position;

    @Basic
    @Column(name = "passport_number")
    private Integer passportNumber;

    @Basic
    @Column(name = "salary")
    private Float salary;

    @Basic
    @Column(name = "permision")
    private Integer permision;

    @ManyToOne
    @JoinColumn(name = "park_id", referencedColumnName = "id", nullable = false)
    private Park parkId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) &&
                Objects.equals(firstName, worker.firstName) &&
                Objects.equals(lastName, worker.lastName) &&
                Objects.equals(position, worker.position) &&
                Objects.equals(passportNumber, worker.passportNumber) &&
                Objects.equals(salary, worker.salary) &&
                Objects.equals(permision, worker.permision) &&
                Objects.equals(parkId, worker.parkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, position, passportNumber, salary, permision, parkId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-30s | %-30s | %-20s | %-20s | %-20s |",
                id, firstName, lastName, position, passportNumber, salary, permision, parkId);
    }
}
