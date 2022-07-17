package kz.samgau.library.auth.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StudentDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String studentId;
    private String password;
    private String email;
    private LocalDate birthday;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String semester;
}
