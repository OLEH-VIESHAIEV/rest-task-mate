package com.example.resttaskmate.repository;

import com.example.resttaskmate.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b FROM Book b INNER JOIN Author a ON b.author.id = a.id "
            + "WHERE a.authorName =:authorName")
    List<Book> findAllByAuthorName(String authorName);

    @Query(value = "SELECT b FROM Book b "
            + "INNER JOIN Author a ON b.author.id = a.id WHERE a.authorName =:authorName "
            + "AND b.soldAmount = (SELECT MAX(book.soldAmount) "
            + "FROM Book book WHERE book.author.authorName =: authorName)")
    Book findMostSellingBookByAuthorName(String authorName);

    @Query(value = "SELECT b FROM Book b "
            + "INNER JOIN Author a ON b.author.id = a.id WHERE a.authorName =:authorName "
            + "AND b.publishedAmount = (SELECT MAX(book.publishedAmount) "
            + "FROM Book book WHERE book.author.authorName =: authorName)")
    Book findMostPublishedBookByAuthorName(String authorName);

    @Query(value = "SELECT b FROM Book b "
            + "INNER JOIN Author a ON b.author.id = a.id WHERE a.authorName LIKE %:authorName% "
            + "AND b.soldAmount = (SELECT MAX(book.soldAmount) "
            + "FROM Book book WHERE book.author.authorName = b.author.authorName)")
    List<Book> findAllMostSellingBooksByPartAuthorName(String authorName);

    @Query(value = "SELECT b FROM Book b "
            + "INNER JOIN Author a ON b.author.id = a.id WHERE a.authorName LIKE %:authorName% "
            + "AND b.publishedAmount = (SELECT MAX(book.publishedAmount) "
            + "FROM Book book WHERE book.author.authorName = b.author.authorName)")
    List<Book> findAllMostPublishedBooksByPartAuthorName(String authorName);

    @Query(value = "SELECT b FROM Book b "
            + "INNER JOIN Author a ON b.author.id = a.id WHERE a.authorName LIKE %:authorName% AND "
            + "b.soldAmount / b.publishedAmount = "
            + "(SELECT MAX(book.soldAmount / book.publishedAmount) "
            + "FROM Book book WHERE book.author.authorName = b.author.authorName)")
    List<Book> findAllMostSuccessfulBooksByPartAuthorName(String authorName);
}
