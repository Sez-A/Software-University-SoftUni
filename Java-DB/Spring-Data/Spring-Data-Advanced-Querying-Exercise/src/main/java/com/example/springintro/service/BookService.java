package com.example.springintro.service;

import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksByAgeRestriction(String toUpperCase);

    List<String> findAllBooksWithEditionTypeAndCopiesLessThan(String editionType, int copies);

    List<String> findAllBooksWithPriceLowerThanAndHigherThan(BigDecimal lowerBoundPrice, BigDecimal upperBoundPrice);

    List<String> findAllBooksNotReleasedIn(int year);

    List<String> findAllBooksReleaseDateBefore(LocalDate releaseDate);

    List<String> findAllBooksByContainingString(String containingStr);

    List<String> findAllBooksWithAuthorLastNameStartsWith(String startsWith);

    int findAllBooksCountWithLengthLongerThan(int length);

    String findBookByName(String bookName);
}
