package com.database.terminal;

import com.database.config.Config;
import com.database.domain.dto.json.PlanetImportJSONDto;
import com.database.domain.dto.json.SolarSystemImportJSONDto;
import com.database.domain.dto.json.StarImportJSONDto;
import com.database.io.interfaces.ConsoleIO;
import com.database.parser.interfaces.FileParser;
import com.database.service.PlanetService;
import com.database.service.SolarSystemService;
import com.database.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    @Qualifier(value = "JSONParser")
    private FileParser jsonParser;

    @Autowired
    @Qualifier(value = "XMLParser")
    private FileParser xmlParser;

    @Autowired
    private ConsoleIO consoleIO;
    @Autowired
    private PlanetService planetService;
    @Autowired
    private SolarSystemService solarSystemService;
    @Autowired
    private StarService starService;

    @Override
    public void run(String... strings) throws Exception {
        this.importSolarSystemFromJSON();
        this.importStarFromJSON();
        this.importPlanetsFromJSON();

    }

    private void importSolarSystemFromJSON() {
        SolarSystemImportJSONDto[] solarSystemImportJSONDtos = null;
        try {
            solarSystemImportJSONDtos = this.jsonParser.read(SolarSystemImportJSONDto[].class, Config.SOLAR_SYSTEM_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (SolarSystemImportJSONDto solarSystemImportJSONDto : solarSystemImportJSONDtos) {
            try {
                this.solarSystemService.create(solarSystemImportJSONDto);
                this.consoleIO.write(String.format("Successfully imported Solar System %s.", solarSystemImportJSONDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }

    private void importStarFromJSON() {
        StarImportJSONDto[] starImportJSONDtos = null;
        try {
            starImportJSONDtos = this.jsonParser.read(StarImportJSONDto[].class, Config.STARS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (StarImportJSONDto starImportJSONDto : starImportJSONDtos) {
            try {
                this.starService.create(starImportJSONDto);
                this.consoleIO.write(String.format("Successfully imported Star %s.", starImportJSONDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }

    private void importPlanetsFromJSON() {
        PlanetImportJSONDto[] planetImportJSONDtos = null;
        try {
            planetImportJSONDtos = this.jsonParser.read(PlanetImportJSONDto[].class, Config.PLANETS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (PlanetImportJSONDto planetImportJSONDto : planetImportJSONDtos) {
            try {
                this.planetService.create(planetImportJSONDto);
                this.consoleIO.write(String.format("Successfully imported Planet %s.", planetImportJSONDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }
}
