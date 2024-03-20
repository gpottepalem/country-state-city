package com.giri.countrystatecity.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Country Entity
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@Entity
@Table(name = "cities", uniqueConstraints = {
    @UniqueConstraint(name = "uc_name", columnNames = {"name"})
})
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @ToString.Exclude
    private State state; // belongsTo, owning side of the relationship
}
