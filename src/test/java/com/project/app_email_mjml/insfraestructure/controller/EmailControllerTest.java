package com.project.app_email_mjml.insfraestructure.controller;

import com.project.app_email_mjml.application.dto.EmailRequestDto;
import com.project.app_email_mjml.domain.service.IEmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailControllerTest {

    @Mock
    private IEmailService emailService;

    @InjectMocks
    private EmailController emailController;

    private EmailRequestDto requestDto;

    @BeforeEach
    void setUp() {
        requestDto = new EmailRequestDto();
        requestDto.setId(1L);
        requestDto.setFullName("Carlos Pérez");
        requestDto.setEmail("carlos@test.com");
        requestDto.setPhone("+57 3001234567");
        requestDto.setWorkspaceId(1L);
    }

    @Test
    void testSendEmail_Success() throws Exception {
        // Arrange
        doNothing().when(emailService).sendWorkspaceEmail(any(EmailRequestDto.class));

        // Act
        ResponseEntity<String> response = emailController.sendEmail(requestDto);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Correo enviado exitosamente.", response.getBody());
        verify(emailService, times(1)).sendWorkspaceEmail(any(EmailRequestDto.class));
    }
}