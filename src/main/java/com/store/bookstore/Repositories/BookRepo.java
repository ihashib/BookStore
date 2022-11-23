package com.store.bookstore.Repositories;

import com.store.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
