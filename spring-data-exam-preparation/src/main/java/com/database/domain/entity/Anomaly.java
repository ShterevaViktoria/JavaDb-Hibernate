package com.database.domain.entity;

import com.database.domain.entity.base.BaseDomainObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "anomalies")
public class Anomaly extends BaseDomainObject {
    private Planet originPlanet;
    private Planet teleportPlanet;
    private Set<Person> victims;

    public Anomaly() {
        this.setVictims(new HashSet<>());
    }

    @ManyToOne
    @JoinColumn(name = "origin_planet_id", referencedColumnName = "id")
    public Planet getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(Planet originPlanet) {
        this.originPlanet = originPlanet;
    }
    @ManyToOne
    @JoinColumn(name = "teleport_planet_id", referencedColumnName = "id",nullable = false)
    public Planet getTeleportPlanet() {
        return teleportPlanet;
    }

    public void setTeleportPlanet(Planet teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }

    @ManyToMany
    @JoinTable(name = "anomaly_victims",
            joinColumns = @JoinColumn(name = "anomaly_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
    public Set<Person> getVictims() {
        return victims;
    }

    public void setVictims(Set<Person> victims) {
        this.victims = victims;
    }
}
