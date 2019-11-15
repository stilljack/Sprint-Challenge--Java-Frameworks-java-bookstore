package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Authors;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepo extends CrudRepository<Authors, Long> {
}
