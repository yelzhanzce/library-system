package kz.samgau.library.repository;

import kz.samgau.library.model.Book;
import kz.samgau.library.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByShelve_Id(Long id);

    @Query("SELECT SUM(a.price) FROM Student s join s.books a WHERE s = :student")
    Double findPriceOfStudentBooks(@Param("student") Student student);

    @Query("SELECT a FROM Student s join s.books a WHERE s = :student")
    List<Book> findAllBooksForCurrentStudent(@Param("student") Student student);
}
