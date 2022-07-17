package kz.samgau.library.service.impl;

import kz.samgau.library.auth.dto.StudentDTO;
import kz.samgau.library.model.Book;
import kz.samgau.library.model.Student;
import kz.samgau.library.repository.BookRepository;
import kz.samgau.library.repository.StudentRepository;
import kz.samgau.library.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl extends BaseServiceImpl<Student, Long> implements StudentService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    @PostConstruct
    public void init() {
        repository = studentRepository;
    }

    @Override
    public Student createStudent(StudentDTO studentDTO) {

        if (studentRepository.existsByStudentId(studentDTO.getStudentId())){
            throw new RuntimeException("Student with this student id already exists: " + studentDTO.getStudentId());
        }

        Student student = new Student();
        modelMapper.map(studentDTO, student);

        student.setPassword(passwordEncoder.encode(studentDTO.getPassword()));

        return studentRepository.save(student);
    }

    @Override
    public Student addBooksToStudent(List<Long> bookIds) {
        Student currentStudent = findCurrentStudent();
        List<Book> books = bookRepository.findAllById(bookIds);
        currentStudent.getBooks().addAll(books);
        return studentRepository.save(currentStudent);
    }

    @Override
    public Student findCurrentStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String studentId = authentication.getName();
        return studentRepository.findByStudentId(studentId).orElse(null);
    }

    @Override
    public Student removeBookFromStudent(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Student currentStudent = findCurrentStudent();
        currentStudent.getBooks().remove(book);
        return studentRepository.save(currentStudent);
    }
}

