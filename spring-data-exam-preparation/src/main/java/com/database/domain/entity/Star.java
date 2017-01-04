package com.database.domain.entity;

import com.database.domain.entity.base.BaseDomainObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stars")
public class Star extends BaseDomainObject{
    private String name;
    private SolarSystem solarSystem;
    private Set<Planet> planets;

    public Star() {
        this.setPlanets(new HashSet<>());
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
    @OneToMany(mappedBy = "sun",fetch = FetchType.LAZY)
    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }
}
