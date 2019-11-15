package com.lambdaschool.usermodel.services;

import java.awt.print.Book;
import java.util.List;

public interface BooksService {
    List<Book> findAll();

    // Book update(Long id, String bookTitle, String copyright, String ISBN);
}