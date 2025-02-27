package com.zander404.springandjavaerudio.services;

import com.zander404.springandjavaerudio.controller.BookController;
import com.zander404.springandjavaerudio.entities.Book;
import com.zander404.springandjavaerudio.entities.dto.BookDTO;
import com.zander404.springandjavaerudio.entities.dto.mapper.BookMapper;
import com.zander404.springandjavaerudio.exceptions.BookNotFoundException;
import com.zander404.springandjavaerudio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

    @Autowired
    private BookRepository repository;

    public List<BookDTO> getAllBooks() {
        List<Book> books = repository.findAll();
        return BookMapper.toListDto(books);
    }

    public BookDTO getBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found!"));
        BookDTO bookDTO = BookMapper.toDto(book);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return bookDTO;
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = BookMapper.toEntity(bookDTO);
        repository.save(book);
        return bookDTO;
    }

    public BookDTO updateBook(Long id, BookDTO dto) {
        Book oldObj = repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found!"));
        Book newObj = BookMapper.toEntity(dto);

        updateObj(oldObj, newObj);

        return BookMapper.toDto(repository.save(oldObj));

    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }


    private void updateObj(Book oldObj, Book newObj) {
        oldObj.setTitle(newObj.getTitle());
        oldObj.setAuthor(newObj.getAuthor());
        oldObj.setPrice(newObj.getPrice());
        oldObj.setLaunchDate(newObj.getLaunchDate());
    }


}
