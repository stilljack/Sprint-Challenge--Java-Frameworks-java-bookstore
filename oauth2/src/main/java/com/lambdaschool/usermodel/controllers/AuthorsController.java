package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.handlers.RestExceptionHandler;
import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Authors;
import com.lambdaschool.usermodel.models.Books;
import com.lambdaschool.usermodel.services.AuthorsService;
import com.lambdaschool.usermodel.services.BooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Loggable
@Controller
public class AuthorsController {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    @Autowired
    private AuthorsService authorService;
    //GET /books/books - returns a JSON object list of all the books, thier sections, and their authors.
    // http://localhost:2019/books/books
    /**
     * GET
     * http://localhost:2019/authors/authors
     * returns a JSON object list of all the authors, their books, and the book's section
     * */
    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> listAllAuthors(HttpServletRequest request) {

        logger.trace(request.getMethod().toUpperCase() + "_" + request.getRequestURI());
        List<Authors> myAuthors = authorService.findAll();
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }
}
