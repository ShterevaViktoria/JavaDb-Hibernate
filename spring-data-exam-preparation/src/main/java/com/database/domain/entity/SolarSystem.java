package com.database.domain.entity;

import com.database.domain.entity.base.BaseDomainObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "solar_systems")
public class SolarSystem extends BaseDomainObject {

    private String name;
    private Set<Star> stars;
    private Set<Planet> planets;

    public SolarSystem() {
        this.setStars(new HashSet<>());
    }

    @Column(name = "name", length = 45, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "solarSystem" ,fetch = FetchType.LAZY)
    public Set<Star> getStars() {
        return stars;
    }

    public void setStars(Set<Star> stars) {
        this.stars = stars;
    }
    @OneToMany(mappedBy = "solarSystem" ,fetch = FetchType.LAZY)
    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }
}
