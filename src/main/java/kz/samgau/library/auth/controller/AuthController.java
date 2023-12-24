package kz.samgau.library.auth.controller;

import kz.samgau.library.auth.dto.LoginRequestDTO;
import kz.samgau.library.auth.dto.LoginResponseDTO;
import kz.samgau.library.auth.dto.StudentDTO;
import kz.samgau.library.model.Student;
import kz.samgau.library.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final StudentService studentService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDTO> signIn(@RequestBody LoginRequestDTO student) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(student.getStudentId(), student.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setAuthenticated(true);  //TODO need refactor
        responseDTO.setStudentId(student.getStudentId());
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/signup")
    public ResponseEntity<HashMap<String, String>> signUp(@RequestBody StudentDTO studentDTO) {
        Student student = studentService.createStudent(studentDTO);

        HashMap<String, String> response = new HashMap<>();
        response.put("studentId", student.getStudentId());
        return ResponseEntity.ok(response);
    }
}
