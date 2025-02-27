package com.zander404.springandjavaerudio.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.zander404.springandjavaerudio.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "title", "author", "launchDate", "price"})
public class BookDTO  extends RepresentationModel<BookDTO> implements Serializable {

    @JsonIgnore
    private Long id;
    private String title;
    private String author;
    private Date lauchDate;
    private Double price;


    public BookDTO(Book book) {
        BookDTO dto = new BookDTO();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.lauchDate = book.getLaunchDate();
        dto.price = book.getPrice();
    }

}
