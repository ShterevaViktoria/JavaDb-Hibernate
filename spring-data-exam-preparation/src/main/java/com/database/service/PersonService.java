package com.database.service;


import com.database.domain.dto.json.PersonImportJSONDto;

public interface PersonService {
    void create(PersonImportJSONDto personImportJSONDto);
}
