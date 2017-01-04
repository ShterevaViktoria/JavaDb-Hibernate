package com.database.serviceImpl;

import com.database.domain.dto.json.PersonImportJSONDto;
import com.database.domain.entity.Person;
import com.database.parser.interfaces.ModelParser;
import com.database.repository.PersonRepository;
import com.database.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(PersonImportJSONDto personImportJSONDto) {
        Person person=this.modelParser.convert(personImportJSONDto,Person.class);


    }
}
