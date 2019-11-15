package com.lambdaschool.usermodel.services;
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
    UserAuditing userAuditing;

    @Autowired
    private AuthorsRepo authorrepos;

    @Override
    public List<Authors> findAll() {

        List<Authors> list = new ArrayList<>();
        authorrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}