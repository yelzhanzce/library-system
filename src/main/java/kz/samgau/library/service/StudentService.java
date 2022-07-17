package kz.samgau.library.service;

import kz.samgau.library.auth.dto.StudentDTO;
import kz.samgau.library.model.Student;

import java.util.List;

public interface StudentService extends BaseService<Student, Long> {
    Student createStudent(StudentDTO student);

    Student addBooksToStudent(List<Long> bookIds);

    Student findCurrentStudent();

    Student removeBookFromStudent(Long bookId);

}
