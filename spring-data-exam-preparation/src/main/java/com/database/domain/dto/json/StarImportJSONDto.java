package com.database.domain.dto.json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StarImportJSONDto  implements Serializable{
    @Expose
    private String name;
    @SerializedName(value = "solarSystem")
    @Expose
    private String solarSystemName;

    public StarImportJSONDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }
}
