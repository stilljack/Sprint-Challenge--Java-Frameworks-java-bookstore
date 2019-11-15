package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Loggable
    @Service(value = "bookService")
    public class BooksServiceImpl implements BookService {

        @Autowired
        BookRepository bookRepository;

        @Override
        public List<Book> findAll() {
            List<Book> list = new ArrayList<>();
            bookRepository.findAll()
                    .iterator().forEachRemaining(list::add);
            return list;
        }

   /* @Override
    public Book update(Long id, String bookTitle, String copyright, String ISBN) {
        return null;
    }*/
    }
}
