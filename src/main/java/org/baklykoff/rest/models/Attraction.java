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
@Table(name="attraction", schema="mydb")
@Data
public class Attraction extends GeneralModel {
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
    @Column(name = "max_visitors")
    @NotNull(message = "Missing maxVisitors")
    @Min(1)
    @Max(999999)
    private Integer maxVisitors;

    @Basic
    @Column(name = "min_permision")
    @NotNull(message = "Missing minPermision")
    @Min(1)
    @Max(999999)
    private Integer minPermision;

    @Basic
    @Column(name = "has_option_vip")
    @NotNull(message = "Missing hasOptionVip")
    @Min(0)
    @Max(1)
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
