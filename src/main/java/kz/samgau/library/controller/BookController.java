package kz.samgau.library.controller;

import kz.samgau.library.model.Book;
import kz.samgau.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/shelve/{id}")
    public ResponseEntity<List<Book>> findByShelve(@PathVariable("id") Long shelveId) {
        return ResponseEntity.ok(bookService.findByShelve(shelveId));
    }

    @GetMapping("/student")
    public ResponseEntity<List<Book>> findAllBooksForCurrentStudent(){
        return ResponseEntity.ok(bookService.findAllBooksForCurrentStudent());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<Book>> findAllBooksByStudentId(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.findAllBooksByStudentId(id));
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveOrUpdate(book));
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveOrUpdate(book));
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/priceByCurrentStudent")
    public ResponseEntity<Double> findPriceOfCurrentStudentBooks() {
        return ResponseEntity.ok(bookService.findPriceOfCurrentStudentBooks());
    }

    @GetMapping("/priceByStudent/{id}")
    public ResponseEntity<Double> findPriceOfStudentBooks(@PathVariable("id") Long studentId) {
        return ResponseEntity.ok(bookService.findPriceOfStudentBooks(studentId));
    }
}
