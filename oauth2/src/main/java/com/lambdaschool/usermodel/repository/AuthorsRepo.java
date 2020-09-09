package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Authors;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface AuthorsRepo extends CrudRepository<Authors, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote (bookid, authorid) VALUES (:bookid, :authorid)", nativeQuery = true)
    void createAuthorBooks(long bookid, long authorid);
}
