package com.database.repository;

import com.database.domain.entity.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarSystemRepository extends JpaRepository<SolarSystem,Long>{
    SolarSystem findOneByName(String name);
}
