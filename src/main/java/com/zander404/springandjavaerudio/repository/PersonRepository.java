package com.zander404.springandjavaerudio.repository;

import com.zander404.springandjavaerudio.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
