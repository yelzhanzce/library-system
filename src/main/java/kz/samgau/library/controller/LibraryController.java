package kz.samgau.library.controller;

import kz.samgau.library.model.Library;
import kz.samgau.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping
    public ResponseEntity<List<Library>> findAll(){
        return ResponseEntity.ok(libraryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(libraryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Library> create(@RequestBody Library library){
        return ResponseEntity.ok(libraryService.saveOrUpdate(library));
    }

    @PutMapping
    public ResponseEntity<Library> update(@RequestBody Library library){
        return ResponseEntity.ok(libraryService.saveOrUpdate(library));
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        libraryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
