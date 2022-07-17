package kz.samgau.library.controller;

import kz.samgau.library.model.Shelve;
import kz.samgau.library.service.ShelveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelve")
@RequiredArgsConstructor
public class ShelveController {
    private final ShelveService shelveService;

    @GetMapping
    public ResponseEntity<List<Shelve>> findAll(){
        return ResponseEntity.ok(shelveService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shelve> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(shelveService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Shelve> create(@RequestBody Shelve shelve){
        return ResponseEntity.ok(shelveService.saveOrUpdate(shelve));
    }

    @PutMapping
    public ResponseEntity<Shelve> update(@RequestBody Shelve shelve){
        return ResponseEntity.ok(shelveService.saveOrUpdate(shelve));
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        shelveService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
