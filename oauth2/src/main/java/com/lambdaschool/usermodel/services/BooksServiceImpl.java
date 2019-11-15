package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Books;
import com.lambdaschool.usermodel.repository.BooksRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Loggable
@Service(value = "bookService")
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRespository bookRepository;

    @Override
    public List<Books> findAll() {
        List<Books> list = new ArrayList<>();
        bookRepository.findAll()
                .iterator().forEachRemaining(list::add);
        return list;
    }

   /* @Override
    public Book update(Long id, String bookTitle, String copyright, String ISBN) {
        return null;
    }*/
}

