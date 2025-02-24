package com.zander404.springandjavaerudio.controller;

import com.zander404.springandjavaerudio.entities.Person;
import com.zander404.springandjavaerudio.services.PersonServices;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;


    @GetMapping("/")
    public List<Person> getAllPersons(){
        return service.findAll();

    }



    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") String id){
        return service.findById(id);

    }

    @PostMapping("/")
    public Person createPerson(@RequestBody Person person){
        return service.create(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathParam(value = "id") String id, @RequestBody Person person){
        return service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public Person deletePerson(@PathParam(value = "id") String id){
        return service.delete(id);
    }



}
