package kz.samgau.library.service.impl;

import kz.samgau.library.model.Book;
import kz.samgau.library.model.Student;
import kz.samgau.library.repository.BookRepository;
import kz.samgau.library.service.BookService;
import kz.samgau.library.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl extends BaseServiceImpl<Book, Long> implements BookService {

    private final BookRepository bookRepository;
    private final StudentService studentService;

    @PostConstruct
    public void init() {
        repository = bookRepository;
    }

    @Override
    public List<Book> findByShelve(Long shelveId) {
        return bookRepository.findAllByShelve_Id(shelveId);
    }

    @Override
    public Double findPriceOfCurrentStudentBooks() {
        Student currentStudent = studentService.findCurrentStudent();
        Double priceOfStudentBooks = bookRepository.findPriceOfStudentBooks(currentStudent);
        if (priceOfStudentBooks == null){
            return 0D;
        }
        return bookRepository.findPriceOfStudentBooks(currentStudent);
    }

    @Override
    public Double findPriceOfStudentBooks(Long studentId) {
        Student student = studentService.findById(studentId);
        return bookRepository.findPriceOfStudentBooks(student);
    }

    @Override
    public List<Book> findAllBooksForCurrentStudent() {
        Student currentStudent = studentService.findCurrentStudent();
        return bookRepository.findAllBooksForCurrentStudent(currentStudent);
    }

    @Override
    public List<Book> findAllBooksByStudentId(Long id) {
        Student student = studentService.findById(id);
        return bookRepository.findAllBooksForCurrentStudent(student);
    }
}
