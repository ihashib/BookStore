package com.store.bookstore.Repositories;

import com.store.bookstore.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
