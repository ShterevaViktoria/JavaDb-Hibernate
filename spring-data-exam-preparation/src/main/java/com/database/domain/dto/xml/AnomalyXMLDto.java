package com.database.domain.dto.xml;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "anomaly")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomalyXMLDto {
    @XmlAttribute(name = "origin-planet")
    private String originPlanetName;
    @XmlAttribute(name = "teleport-planet")
    private String teleportPlanetName;
    @XmlElementWrapper(name = "victims")
    @XmlAttribute(name = "victim")
    private Set<VictimXMLDto> persons;

    public AnomalyXMLDto() {
        this.setPersons(new HashSet<>());
    }

    public String getOriginPlanetName() {
        return originPlanetName;
    }

    public void setOriginPlanetName(String originPlanetName) {
        this.originPlanetName = originPlanetName;
    }

    public String getTeleportPlanetName() {
        return teleportPlanetName;
    }

    public void setTeleportPlanetName(String teleportPlanetName) {
        this.teleportPlanetName = teleportPlanetName;
    }

    public Set<VictimXMLDto> getPersons() {
        return persons;
    }

    public void setPersons(Set<VictimXMLDto> persons) {
        this.persons = persons;
    }
}
