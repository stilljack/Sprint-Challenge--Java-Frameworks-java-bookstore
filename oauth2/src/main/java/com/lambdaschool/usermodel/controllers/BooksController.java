package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.handlers.RestExceptionHandler;
import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Books;
import com.lambdaschool.usermodel.models.Wrote;
import com.lambdaschool.usermodel.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Loggable
@Controller
public class BooksController {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
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


        @PutMapping(value = "books/{bookid}", consumes = {"application/json"})
        public ResponseEntity<?> updateBook( @RequestBody
                                                     Books updatedBook,
                                             @PathVariable
                                                     long bookid)
        {
            booksService.update(updatedBook, bookid);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PostMapping(value = "books/{bookid}/authors/{authorid}", consumes = {"application/json"})
        public ResponseEntity<?> addNewBookWrote(@PathVariable long bookid, @PathVariable long authorid)
        {
            Wrote newBookAuthor = booksService.save(bookid, authorid);


            HttpHeaders responseHeaders = new HttpHeaders();
            URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{bookid}").buildAndExpand(newBookAuthor.getBook().getBookid()).toUri();
            responseHeaders.setLocation(newRestaurantURI);

            return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
        }

        @DeleteMapping(value = "/books/{bookid}", consumes = {"application/json"})
        public ResponseEntity<?> deleteBook(@PathVariable long bookid){
            booksService.delete(bookid);
            return new ResponseEntity<>(HttpStatus.OK);
        }




}
