package kz.samgau.library.service;

import kz.samgau.library.model.Book;

import java.util.List;

public interface BookService extends BaseService<Book, Long> {
    List<Book> findByShelve(Long shelveId);

    Double findPriceOfCurrentStudentBooks();

    Double findPriceOfStudentBooks(Long studentId);

    List<Book> findAllBooksForCurrentStudent();

    List<Book> findAllBooksByStudentId(Long id);
}
