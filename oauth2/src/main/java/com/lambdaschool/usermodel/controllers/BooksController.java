package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Books;
import com.lambdaschool.usermodel.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Loggable
@Controller
public class BooksController {
    private static final Logger logger = LoggerFactory.getLogger(OpenController.class);
    @Autowired
    private BooksService booksService;
    //GET /books/books - returns a JSON object list of all the books, thier sections, and their authors.
    // http://localhost:2019/books/books

    @GetMapping(value = "/books",
            produces = {"application/json"})
    public ResponseEntity<?> listBooks(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Books> allBooks = booksService.findAll();
        return new ResponseEntity<>(allBooks,
                HttpStatus.OK);
    }
}