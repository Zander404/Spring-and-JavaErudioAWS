package com.zander404.springandjavaerudio.services;

import com.zander404.springandjavaerudio.entities.Person;
import com.zander404.springandjavaerudio.exceptions.PersonNotFound;
import com.zander404.springandjavaerudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Find all persons");

        return repository.findAll();
    }


    @Transactional
    public Person findById(Long id) {

        logger.info("Finding One Person");
        return repository.findById(id).orElseThrow(() -> new PersonNotFound("Person with this ID not found!"));

    }


    public Person create(Person person) {
        logger.info("Creating Person");
        return repository.save(person);
    }

    public Person update(Long id, Person person) {
        logger.info("Updating Person");
        Person oldObj = findById(id);
        updateInfo(person, oldObj);

        repository.save(oldObj);
        return person;
    }

    public Person delete(Long id) {
        logger.info("Deleting Person");
        repository.deleteById(id);
        return null;
    }


    public void updateInfo(Person newObj, Person oldObj){

        oldObj.setFirstName(newObj.getFirstName());
        oldObj.setLastName(newObj.getLastName());
        oldObj.setAddress(newObj.getAddress());
        oldObj.setGender(newObj.getGender());
    }
}