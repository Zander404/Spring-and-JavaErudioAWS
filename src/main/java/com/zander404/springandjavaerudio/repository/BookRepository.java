package com.zander404.springandjavaerudio.repository;

import com.zander404.springandjavaerudio.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
