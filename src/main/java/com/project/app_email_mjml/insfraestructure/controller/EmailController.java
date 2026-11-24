package com.project.app_email_mjml.insfraestructure.controller;

import com.project.app_email_mjml.application.dto.EmailRequestDto;
import com.project.app_email_mjml.domain.service.IEmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
@Tag(name = "Servicio de Correo", description = "Endpoints para la gestión y envío de notificaciones por correo electrónico con MJML y Thymeleaf")
public class EmailController {
    private IEmailService iEmailService;

    @Autowired
    public EmailController(IEmailService iEmailService) {
        this.iEmailService = iEmailService;
    }

    @Operation(
            summary = "Enviar correo electrónico asíncrono",
            description = "Recibe los datos del usuario y del área de trabajo, procesa la plantilla MJML y envía el correo electrónico en segundo plano."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitud aceptada y correo en proceso de envío asíncrono",
                    content = @Content(mediaType = "text/plain", schema = @Schema(example = "Solicitud de correo recibida y procesándose en segundo plano."))),
            @ApiResponse(responseCode = "400", description = "Error de validación en los campos de la petición",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailRequestDto request) {
        try {
            iEmailService.sendWorkspaceEmail(request);
            return ResponseEntity.ok("Correo enviado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al enviar el correo: " + e.getMessage());
        }
    }
}
