package kz.samgau.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponse {
    private LocalDateTime date;
    private String message;
    private String details;
}
