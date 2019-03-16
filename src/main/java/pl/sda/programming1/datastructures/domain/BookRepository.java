package pl.sda.programming1.datastructures.domain;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findByTitle(String title);
}
