package com.lambdaschool.usermodel.services;
import com.lambdaschool.usermodel.models.Authors;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AuthorsService {
    Authors findAuthorById(long authorid);

    List<Authors> findAll();

    void createAuthorBooks(long bookid, long authorid);
}

