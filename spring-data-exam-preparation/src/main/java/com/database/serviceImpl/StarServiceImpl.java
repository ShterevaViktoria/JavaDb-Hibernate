package com.database.serviceImpl;

import com.database.domain.dto.json.StarImportJSONDto;
import com.database.domain.entity.SolarSystem;
import com.database.domain.entity.Star;
import com.database.parser.interfaces.ModelParser;
import com.database.repository.StarRepository;
import com.database.service.SolarSystemService;
import com.database.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StarServiceImpl implements StarService{
    @Autowired
    private StarRepository starRepository;
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private SolarSystemService solarSystemService;
    @Override
    public void create(StarImportJSONDto starImportJSONDto) {
        Star star=this.modelParser.convert(starImportJSONDto,Star.class);
        SolarSystem solarSystem=this.solarSystemService.findOneByName(star.getSolarSystem().getName());
        star.setSolarSystem(solarSystem);
        this.starRepository.saveAndFlush(star);

    }

    @Override
    public Star findOneByName(String name) {
        return this.starRepository.findOneByName(name);
    }
}
