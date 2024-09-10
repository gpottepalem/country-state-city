package com.giri.countrystatecity.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Country Entity
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@Entity
@Table(name = "states", uniqueConstraints = {
    @UniqueConstraint(name = "uc_name", columnNames = {"name"})
})
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class State extends BaseEntity {
    private String name;
    private String code;
    private Long population = 100L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    @ToString.Exclude
    private Country country; // belongsTo, owning side of the relationship

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private Set<City> cities = new LinkedHashSet<>(); // hasMany

    /**
     * Helper, add all cities by setting this as state reference (owning side) on them.
     * @param citiesToAdd
     */
    public void addCities(@NonNull Set<City> citiesToAdd) {
        citiesToAdd.forEach(city -> city.setState(this));
        this.cities.addAll(citiesToAdd);
    }
}
