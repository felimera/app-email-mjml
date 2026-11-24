package com.project.app_email_mjml.insfraestructure.controller;

import com.project.app_email_mjml.application.dto.EmailRequestDto;
import com.project.app_email_mjml.domain.service.IEmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    private IEmailService iEmailService;

    @Autowired
    public EmailController(IEmailService iEmailService) {
        this.iEmailService = iEmailService;
    }

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
