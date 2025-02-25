package com.zander404.springandjavaerudio.entities.dto.mapper;

import com.zander404.springandjavaerudio.entities.Person;
import com.zander404.springandjavaerudio.entities.dto.PersonDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMapper {

    public static Person toPerson(PersonDTO dto) {
        return new ModelMapper().map(dto, Person.class);
    }

    public static PersonDTO toDto(Person person) {
        return new ModelMapper().map(person, PersonDTO.class);
    }


    public static List<PersonDTO> toListDto(List<Person> listPersons) {
        return listPersons.stream().map(PersonMapper::toDto).collect(Collectors.toList());
    }
}
