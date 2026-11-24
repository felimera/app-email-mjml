package com.project.app_email_mjml.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDto {
    @Schema(description = "Correo electrónico del destinatario", example = "test@test.com")
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe proporcionar un formato de correo electrónico válido")
    private String email;
    private Long id;
    @Schema(description = "Nombre completo del usuario", example = "Juan Pérez")
    @NotBlank(message = "El nombre completo es obligatorio")
    private String fullName;
    @Schema(description = "Número de teléfono de contacto", example = "+57 300000000")
    @NotBlank(message = "El número de teléfono es obligatorio")
    private String phone;
    @Schema(description = "ID del workspace asociado", example = "1")
    @NotNull(message = "El ID del workspace es obligatorio")
    private Long workspaceId;
}
