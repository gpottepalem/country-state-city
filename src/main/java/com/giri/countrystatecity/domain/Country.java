package com.giri.countrystatecity.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@Table(name = "countries", uniqueConstraints = {
    @UniqueConstraint(name = "uc_name", columnNames = {"name"})
})
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Country extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private Set<State> states = new LinkedHashSet<>(); // hasMany

    /**
     * Helper, add all states by setting this as country reference (owning side) on them.
     *
     * @param statesToAdd
     */
    public void addStates(@NonNull Set<State> statesToAdd) {
        statesToAdd.forEach(state -> state.setCountry(this));
        this.states.addAll(statesToAdd);
    }
}
