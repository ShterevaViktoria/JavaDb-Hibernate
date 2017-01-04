package com.database.service;


import com.database.domain.dto.json.PlanetImportJSONDto;

public interface PlanetService {
    void create(PlanetImportJSONDto planetImportJSONDto);
}
