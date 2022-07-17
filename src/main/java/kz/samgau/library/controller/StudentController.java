package kz.samgau.library.controller;

import kz.samgau.library.model.Student;
import kz.samgau.library.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/current")
    public ResponseEntity<Student> findCurrentStudent(){
        return ResponseEntity.ok(studentService.findCurrentStudent());
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.ok(studentService.saveOrUpdate(student));
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student){
        return ResponseEntity.ok(studentService.saveOrUpdate(student));
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-books")
    public ResponseEntity<Student> addBooks(@RequestParam("ids") List<Long> bookIds){
        return ResponseEntity.ok(studentService.addBooksToStudent(bookIds));
    }

    @PostMapping("/delete-book/{id}")
    public ResponseEntity<Student> removeBooks(@PathVariable("id") Long bookId){
        return ResponseEntity.ok(studentService.removeBookFromStudent(bookId));
    }
}
