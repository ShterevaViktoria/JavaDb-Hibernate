package com.database.repository;

import com.database.domain.entity.SolarSystem;
import com.database.domain.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends JpaRepository<Star,Long>{
    Star findOneByName(String name);
}
