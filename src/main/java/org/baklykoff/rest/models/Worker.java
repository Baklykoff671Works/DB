package org.baklykoff.rest.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull(message = "Missing firstName")
    @Size(min=1, max=45)
    private String firstName;

    @Basic
    @Column(name = "last_name")
    @NotNull(message = "Missing lastName")
    @Size(min=1, max=45)
    private String lastName;

    @Basic
    @Column(name = "position")
    @NotNull(message = "Missing position")
    @Size(min=1, max=45)
    private String position;

    @Basic
    @Column(name = "passport_number")
    @NotNull(message = "Missing passportNumber")
    @Min(1)
    @Max(99999999)
    private Integer passportNumber;

    @Basic
    @Column(name = "salary")
    @NotNull(message = "Missing salary")
    @Min(1)
    @Max(999999)
    private Float salary;

    @Basic
    @Column(name = "permision")
    @NotNull(message = "Missing permision")
    @Min(1)
    @Max(5)
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
