package com.store.bookstore.Bootstrap;

import com.store.bookstore.Repositories.AuthorRepo;
import com.store.bookstore.Repositories.BookRepo;
import com.store.bookstore.Repositories.PublisherRepo;
import com.store.bookstore.domain.Author;
import com.store.bookstore.domain.Book;
import com.store.bookstore.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner{
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Raiha", "Rahman");
        Book book = new Book("ABC", "KD1");
        Publisher publisher = new Publisher("Pro", "addr", "dhaka", "BD", "1212");
        publisherRepo.save(publisher);

        author.getBook().add(book);

        book.getAuthors().add(author);
        book.setPublisher(publisher);

        publisher.getBook().add(book);

        authorRepo.save(author);
        bookRepo.save(book);

        System.out.println("Number of books: "+bookRepo.count());



        System.out.println("Publisher count: "+publisherRepo.count());

    }
}
