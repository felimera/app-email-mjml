package com.project.app_email_mjml.application.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private Map<String, String> details; // Útil para errores de validación por campo
}
