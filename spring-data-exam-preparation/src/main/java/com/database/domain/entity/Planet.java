package com.database.domain.entity;

import com.database.domain.entity.base.BaseDomainObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "planets")
public class Planet extends BaseDomainObject {
    private String name;
    private SolarSystem solarSystem;
    private Star sun;
    private Set<Anomaly> originAnomalies;
    private Set<Anomaly> teleportAnomalies;
    private Set<Person> persons;

    public Planet() {
        this.setOriginAnomalies(new HashSet<>());
        this.setPersons(new HashSet<>());
        this.setTeleportAnomalies(new HashSet<>());
    }

    @Column(name = "name", length = 45, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "solar_system_id", referencedColumnName = "id",nullable = false)
    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    @ManyToOne
    @JoinColumn(name = "sun_id", referencedColumnName = "id",nullable = false)
    public Star getSun() {
        return sun;
    }

    public void setSun(Star sun) {
        this.sun = sun;
    }

    @OneToMany(mappedBy = "originPlanet", fetch = FetchType.LAZY)
    public Set<Anomaly> getOriginAnomalies() {
        return originAnomalies;
    }

    public void setOriginAnomalies(Set<Anomaly> originAnomalies) {
        this.originAnomalies = originAnomalies;
    }

    @OneToMany(mappedBy = "teleportPlanet", fetch = FetchType.LAZY)
    public Set<Anomaly> getTeleportAnomalies() {
        return teleportAnomalies;
    }

    public void setTeleportAnomalies(Set<Anomaly> teleportAnomalies) {
        this.teleportAnomalies = teleportAnomalies;
    }

    @OneToMany(mappedBy = "homePlanet", fetch = FetchType.LAZY)
    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
