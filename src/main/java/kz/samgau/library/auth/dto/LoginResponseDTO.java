package kz.samgau.library.auth.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String studentId;
    private boolean authenticated;
}
