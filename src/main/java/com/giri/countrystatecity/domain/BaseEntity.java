package com.giri.countrystatecity.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Base entity with common attributes:
 *   . id (surrogate-key)
 *   . version(for optimistic locking)
 *   . dateCreated
 *   . lastUpdated
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@Data
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @ToString.Exclude
    protected Long id;

    /** For optimistic locking */
    @Version
    protected Long version;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    protected OffsetDateTime dateCreated = OffsetDateTime.now();

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    protected OffsetDateTime lastUpdated = OffsetDateTime.now();

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        Class<?> oEffectiveClass;
        if (o instanceof HibernateProxy hibernateProxy) {
            oEffectiveClass = hibernateProxy.getHibernateLazyInitializer().getPersistentClass();
        }
        else {
            oEffectiveClass = o.getClass();
        }
        Class<?> thisEffectiveClass;
        if (this instanceof HibernateProxy hibernateProxy) {
            thisEffectiveClass = hibernateProxy.getHibernateLazyInitializer().getPersistentClass();
        }
        else {
            thisEffectiveClass = this.getClass();
        }
        if (thisEffectiveClass != oEffectiveClass)
            return false;
        BaseEntity that = (BaseEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    @Generated
    public int hashCode() {
        if (this instanceof HibernateProxy hibernateProxy) {
            return hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode();
        }
        else {
            return getClass().hashCode();
        }
    }
}

