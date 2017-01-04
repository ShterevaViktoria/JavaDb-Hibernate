package com.database.domain.dto.xml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "anomalies")
public class AnomaliesXMLDto {
    @XmlAttribute(name = "anomaly")
    private Set<AnomalyXMLDto> anomalies;

    public AnomaliesXMLDto() {
        this.setAnomalies(new HashSet<>());
    }

    public Set<AnomalyXMLDto> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(Set<AnomalyXMLDto> anomalies) {
        this.anomalies = anomalies;
    }
    public void add(AnomalyXMLDto anomalyXMLDto){
        this.getAnomalies().add(anomalyXMLDto);
    }
}
