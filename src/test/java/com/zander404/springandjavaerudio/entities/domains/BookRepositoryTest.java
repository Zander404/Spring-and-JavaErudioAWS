package com.zander404.springandjavaerudio.entities.domains;


import com.zander404.springandjavaerudio.controller.BookController;
import com.zander404.springandjavaerudio.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("it")
@DataJpaTest
@WebMvcTest(BookRepository.class)
public class BookRepositoryTest{

    @Autowired
    private BookRepository bookRepository;

//    @Test

}
