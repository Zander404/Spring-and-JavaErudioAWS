package com.zander404.springandjavaerudio.entities.dto.mapper;


import com.zander404.springandjavaerudio.entities.Book;
import com.zander404.springandjavaerudio.entities.dto.BookDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookMapper {
    public static BookDTO toDto(Book book) {
        return new ModelMapper().map(book, BookDTO.class);
    }

    public static Book toEntity(BookDTO dto) {
        return new ModelMapper().map(dto, Book.class);
    }

    public static List<BookDTO> toListDto(List<Book> listBooks) {
        return listBooks.stream().map(BookMapper::toDto).collect(Collectors.toList());
    }
}
