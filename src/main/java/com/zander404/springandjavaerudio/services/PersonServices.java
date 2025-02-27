package com.zander404.springandjavaerudio.services;

import com.zander404.springandjavaerudio.controller.PersonController;
import com.zander404.springandjavaerudio.entities.Person;
import com.zander404.springandjavaerudio.entities.dto.PersonDTO;
import com.zander404.springandjavaerudio.entities.dto.mapper.PersonMapper;
import com.zander404.springandjavaerudio.exceptions.PersonNotFound;
import com.zander404.springandjavaerudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<PersonDTO> findAll() {
        logger.info("Find all persons");
        List<PersonDTO> persons = PersonMapper.toListDto(repository.findAll());

        persons.stream().forEach(p ->
                p.add(linkTo(methodOn(PersonController.class).getPersonById(p.getId())).withSelfRel())
        );


        return PersonMapper.toListDto(repository.findAll());
    }


    public PersonDTO findById(Long id) {

        logger.info("Finding One Person");
        Person person = repository.findById(id).orElseThrow(() -> new PersonNotFound("Person with this ID not found!"));
        PersonDTO dto = PersonMapper.toDto(person);
        dto.add(linkTo(methodOn(PersonController.class).getPersonById(id)).withSelfRel());
        return dto;

    }


    public PersonDTO create(PersonDTO dto) {
        logger.info("Creating Person");
        Person person = PersonMapper.toPerson(dto);
        repository.save(person);

        return PersonMapper.toDto(person);
    }

    public Person update(Long id, PersonDTO dto) {
        logger.info("Updating Person");
        Person person = PersonMapper.toPerson(dto);
        Person oldObj = PersonMapper.toPerson(findById(id));

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