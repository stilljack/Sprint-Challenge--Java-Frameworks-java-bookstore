package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Wrote;
import org.springframework.data.repository.CrudRepository;

public interface WroteRepo extends CrudRepository<Wrote, Long> {
}
