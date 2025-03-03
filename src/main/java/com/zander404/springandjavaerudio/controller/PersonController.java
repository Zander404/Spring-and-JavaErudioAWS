package com.zander404.springandjavaerudio.controller;

import com.zander404.springandjavaerudio.entities.dto.PersonDTO;
import com.zander404.springandjavaerudio.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@Tag(name = "People", description = "Endpoints to Make the CRUD Operations of People Object")
public class PersonController {

    @Autowired
    private PersonServices service;


    @GetMapping(value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    @Operation(
            summary = "Finds all People", description = "Find All People",
            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public List<PersonDTO> getAllPersons() {
        return service.findAll();

    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    @Operation(
            summary = "GET ONE PERSON",
            description = "GET ONE PERSON",

            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO getPersonById(@PathVariable("id") Long id) {
        return service.findById(id);

    }

    @PostMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    @Operation(
            summary = "CREATE PERSON",
            description = "CREATE PERSON",

            responses = {
                    @ApiResponse(description = "SUCCESS", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO createPerson(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    @Operation(
            summary = "UPDATE ONE PERSON",
            description = "UPDATE ONE PERSON",

            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "204",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO updatePerson(@PathVariable(value = "id") Long id, @RequestBody PersonDTO person) {
        System.out.println(id);
        service.update(id, person);
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public String deletePerson(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return "Deleted person with id: " + id;
    }

}
