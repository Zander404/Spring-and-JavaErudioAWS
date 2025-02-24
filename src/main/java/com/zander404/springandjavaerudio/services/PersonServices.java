package com.zander404.springandjavaerudio.services;

import com.zander404.springandjavaerudio.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Person person = mockPerson(Long.parseLong(String.valueOf(i)));
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id) {

        logger.info("Finding One Person");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Leadro");
        person.setLastName("Marcos");
        person.setAddress("San Francisco, CA");
        person.setGender("M");


        return person;

    }


    public Person mockPerson(Long i) {
        Person person = new Person();
        person.setId(i);

        person.setFirstName("Person Name: " + i);
        person.setLastName("Last Name: " + i);
        person.setAddress("Address: " + i);
        person.setGender("Male");
        return person;
    }


    public Person create(Person person) {
        logger.info("Creating Person");
        return new Person(counter.incrementAndGet(),
                person.getFirstName(),
                person.getLastName(),
                person.getAddress(),
                person.getGender());
    }

    public Person update(String id, Person person) {
        logger.info("Updating Person");
        System.out.println(id);
        System.out.println(person);

        return person;
    }

    public Person delete(String id) {
        logger.info("Deleting Person");
        System.out.println(id);
        return null;
    }
}