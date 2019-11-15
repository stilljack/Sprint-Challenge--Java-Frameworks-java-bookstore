package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Books;

import java.awt.print.Book;
import java.util.List;

public interface BooksService {
    List<Books> findAll();

    // Book update(Long id, String bookTitle, String copyright, String ISBN);
}