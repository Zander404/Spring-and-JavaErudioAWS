package com.zander404.springandjavaerudio.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.zander404.springandjavaerudio.entities.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;



@EqualsAndHashCode(callSuper = true)
@Data
@JsonPropertyOrder({"id", "first_name", "last_name", "address", "gender", "links"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String address;

    private String gender;

    private PersonDTO() {};

    public PersonDTO(Person person) {
        PersonDTO dto = new PersonDTO();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
    }

}
