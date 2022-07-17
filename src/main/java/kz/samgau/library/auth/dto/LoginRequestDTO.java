package kz.samgau.library.auth.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String studentId;
    private String password;
}
