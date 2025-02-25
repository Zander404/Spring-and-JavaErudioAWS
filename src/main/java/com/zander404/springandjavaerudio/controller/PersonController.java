package com.zander404.springandjavaerudio.controller;

import com.zander404.springandjavaerudio.entities.Person;
import com.zander404.springandjavaerudio.entities.dto.PersonDTO;
import com.zander404.springandjavaerudio.entities.dto.mapper.PersonMapper;
import com.zander404.springandjavaerudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;


    @GetMapping("/")
    public List<PersonDTO> getAllPersons() {

        return PersonMapper.toListDto(service.findAll());

    }

    @GetMapping("/{id}")
    public PersonDTO getPersonById(@PathVariable("id") Long id) {
        return PersonMapper.toDto(service.findById(id));

    }

    @PostMapping("/")
    public PersonDTO createPerson(@RequestBody PersonDTO person) {
        Person obj = PersonMapper.toPerson(person);
        service.create(obj);
        return PersonMapper.toDto(obj);
    }

    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable(value = "id") Long id, @RequestBody PersonDTO person) {
        System.out.println(id);
        Person obj = PersonMapper.toPerson(person);
        service.update(id, obj);
        return PersonMapper.toDto(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return "Deleted person with id: " + id;
    }



}
