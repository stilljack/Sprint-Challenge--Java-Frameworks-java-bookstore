package com.lambdaschool.usermodel.services;
import com.lambdaschool.usermodel.models.Authors;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AuthorsService {

        List<Authors> findAll();
    }

