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
    @NotNull(message = "Missing name")
    @Size(min=1, max=45)
    private String name;

    @Basic
    @Column(name = "visitors")
    @NotNull(message = "Missing visitors")
    @Min(1)
    @Max(999999)
    private Integer visitors;

    @Basic
    @Column(name = "location")
    @NotNull(message = "Missing location")
    @Size(min=1, max=45)
    private String location;

    @Basic
    @Column(name = "max_visitors")
    @NotNull(message = "Missing maxVisitors")
    @Min(1)
    @Max(999999)
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
