package com.database.serviceImpl;

import com.database.domain.dto.json.SolarSystemImportJSONDto;
import com.database.domain.entity.SolarSystem;
import com.database.parser.interfaces.ModelParser;
import com.database.repository.SolarSystemRepository;
import com.database.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SolarSystemServiceImpl implements SolarSystemService {
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Override
    public void create(SolarSystemImportJSONDto solarSystemImportJSONDto) {
        SolarSystem solarSystem=this.modelParser.convert(solarSystemImportJSONDto,SolarSystem.class);
        this.solarSystemRepository.saveAndFlush(solarSystem);
    }

    @Override
    public SolarSystem findOneByName(String name) {
        return this.solarSystemRepository.findOneByName(name);
    }
}
