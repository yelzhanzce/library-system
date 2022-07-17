package kz.samgau.library.controller;

import kz.samgau.library.model.Course;
import kz.samgau.library.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course){
        return ResponseEntity.ok(courseService.saveOrUpdate(course));
    }

    @PutMapping
    public ResponseEntity<Course> update(@RequestBody Course course){
        return ResponseEntity.ok(courseService.saveOrUpdate(course));
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        courseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
