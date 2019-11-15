package com.lambdaschool.usermodel.services;
import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Authors;
import com.lambdaschool.usermodel.repository.AuthorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorsService {
    @Autowired
    private BooksService booksService;
    @Autowired
    UserAuditing userAuditing;

    @Autowired
    private AuthorsRepo authorrepos;

    @Override
    public Authors findAuthorById(long authorid) {
        return authorrepos.findById(authorid).orElseThrow(() ->
                new ResourceNotFoundException(authorid + " not found"));
    }
    @Override
    public void createAuthorBooks(long bookid, long authorid) {

        booksService.findBookById(bookid);
        findAuthorById(authorid);

        authorrepos.createAuthorBooks(bookid, authorid);
    }
    @Override
    public List<Authors> findAll() {

        List<Authors> list = new ArrayList<>();
        authorrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}