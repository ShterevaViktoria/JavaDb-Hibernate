package com.database.serviceImpl;

import com.database.domain.dto.json.PlanetImportJSONDto;
import com.database.domain.entity.Planet;
import com.database.domain.entity.SolarSystem;
import com.database.domain.entity.Star;
import com.database.parser.interfaces.ModelParser;
import com.database.repository.PlanetRepository;
import com.database.service.PlanetService;
import com.database.service.SolarSystemService;
import com.database.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private ModelParser modelParser;
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private SolarSystemService solarSystemService;
    @Autowired
    private StarService starService;

    @Override
    public void create(PlanetImportJSONDto planetImportJSONDto) {
        Planet planet = this.modelParser.convert(planetImportJSONDto, Planet.class);
        SolarSystem solarSystem = this.solarSystemService.findOneByName(planet.getSolarSystem().getName());
        planet.setSolarSystem(solarSystem);
        Star sun = this.starService.findOneByName(planet.getSun().getName());
        planet.setSun(sun);
        this.planetRepository.saveAndFlush(planet);
    }
}
