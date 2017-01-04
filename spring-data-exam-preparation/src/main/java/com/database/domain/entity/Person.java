package com.database.domain.entity;

import com.database.domain.entity.base.BaseDomainObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person extends BaseDomainObject {
    private String name;
    private Planet homePlanet;
    private Set<Anomaly> anomalies;

    public Person() {
        this.setAnomalies(new HashSet<>());
    }

    @Column(name = "name", length = 45, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne
    @JoinColumn(name = "home_planet_id", referencedColumnName = "id")
    public Planet getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(Planet homePlanet) {
        this.homePlanet = homePlanet;
    }

    @ManyToMany(mappedBy = "victims", targetEntity = Anomaly.class,fetch = FetchType.LAZY)
    public Set<Anomaly> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(Set<Anomaly> anomalies) {
        this.anomalies = anomalies;
    }


}
