package com.database.service;

import com.database.domain.dto.json.StarImportJSONDto;
import com.database.domain.entity.Star;

public interface StarService {
    void create(StarImportJSONDto starImportJSONDto);
    Star findOneByName(String name);
}
