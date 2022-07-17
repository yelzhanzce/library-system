package kz.samgau.library.service.impl;

import kz.samgau.library.model.Course;
import kz.samgau.library.repository.BookRepository;
import kz.samgau.library.repository.CourseRepository;
import kz.samgau.library.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl extends BaseServiceImpl<Course, Long> implements CourseService {

    private final CourseRepository repo;

    @PostConstruct
    public void init(){
        repository = repo;
    }
}
