package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRespository extends CrudRepository<Books, Long> {

}
