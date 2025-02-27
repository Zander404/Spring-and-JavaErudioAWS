package com.zander404.springandjavaerudio.controller;

import com.zander404.springandjavaerudio.entities.dto.BookDTO;
import com.zander404.springandjavaerudio.services.BookServices;
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
@RequestMapping("api/v1/book")
@Tag(name = "Books", description = "EndPoints to MAKE CRUD to Book ENTITY")
public class BookController {


    @Autowired
    private BookServices services;

    @GetMapping(value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    @Operation(
            summary = "GET ALL BOOKS",
            description = "GET ALL BOOKS",

            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public List<BookDTO> findAll() {
        return services.getAllBooks();
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    @Operation(
            summary = "GET ONE BOOK",
            description = "GET ONE BOOK",

            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public BookDTO findById(@PathVariable Long id) {
        return services.getBookById(id);
    }



    @PostMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    @Operation(
            summary = "CREATE BOOK",
            description = "CREATE BOOK",

            responses = {
                    @ApiResponse(description = "SUCCESS", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public BookDTO create(@RequestBody BookDTO bookDTO) {
        return services.createBook(bookDTO);
    }



    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    @Operation(
            summary = "UPDATE ONE BOOK",
            description = "UPDATE ONE BOOK",

            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "204",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public BookDTO update(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return services.updateBook(id, bookDTO);
    }



    @DeleteMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    @Operation(
            summary = "DELETE ONE BOOK",
            description = "DELETE ONE BOOK",

            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "204",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public void delete(@PathVariable Long id) {
        services.deleteBook(id);
    }
}
