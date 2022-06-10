package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findAllByFirstNameEndingWith(String endsWith);

    @Query("SELECT concat(a.firstName, ' ', a.lastName),' - ', " +
            " sum(b.copies) as all_book_cnt FROM Author a join a.books b " +
            " GROUP BY a.id " +
            "ORDER BY all_book_cnt DESC")
    List<String> findAllByBooksCopiesOrderByDESC();
}
