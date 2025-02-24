package com.zander404.springandjavaerudio.entities.dto;

import com.zander404.springandjavaerudio.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonDTO(Person person) {
        PersonDTO dto = new PersonDTO();

        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
    }
}
