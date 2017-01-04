package com.database.service;

import com.database.domain.dto.json.SolarSystemImportJSONDto;
import com.database.domain.entity.SolarSystem;

/**
 * Created by dell on 12/11/2016.
 */
public interface SolarSystemService {

    void create(SolarSystemImportJSONDto solarSystemImportJSONDto);
    SolarSystem findOneByName(String name);

}
