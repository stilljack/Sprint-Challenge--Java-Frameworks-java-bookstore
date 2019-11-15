package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Authors;
import com.lambdaschool.usermodel.models.Books;
import com.lambdaschool.usermodel.models.Wrote;

import java.awt.print.Book;
import java.util.List;

public interface BooksService {
    List<Books> findAll();
    Books update(Books restaurant, long id);
    void delete(long id);
    Authors save(long bookid, long authorid);
    // Book update(Long id, String bookTitle, String copyright, String ISBN);
}