package com.baklykoff.model.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="visitor", schema="mydb")
@Data
public class Visitor extends GeneralModel{

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

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false)
    private Ticket ticketId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(id, visitor.id) &&
                Objects.equals(firstName, visitor.firstName) &&
                Objects.equals(lastName, visitor.lastName) &&
                Objects.equals(ticketId, visitor.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, ticketId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s |",id,firstName,lastName,ticketId);
    }
}
