package com.project.app_email_mjml.application.service;

import com.project.app_email_mjml.application.dto.EmailRequestDto;
import com.project.app_email_mjml.domain.models.Workspaces;
import com.project.app_email_mjml.domain.service.IWorkspacesService;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring6.SpringTemplateEngine;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IEmailServiceImplTest {
    @Mock
    private JavaMailSender mailSender;

    @Mock
    private SpringTemplateEngine templateEngine;

    @Mock
    private IWorkspacesService iWorkspacesService; // Mock de tu servicio de workspaces

    @InjectMocks
    private IEmailServiceImpl emailService; // Inyecta los mocks anteriores dentro del servicio

    private EmailRequestDto requestDto;
    private Workspaces mockWorkspace;

    @BeforeEach
    void setUp() {
        // 1. Datos de prueba simulados que recibiría el endpoint
        requestDto = new EmailRequestDto();
        requestDto.setId(10L);
        requestDto.setFullName("María Pérez");
        requestDto.setEmail("maria@test.com");
        requestDto.setPhone("+57 3009876543");
        requestDto.setWorkspaceId(1L);

        // 2. Workspace simulado que devolverá el H2 / servicio de workspaces
        mockWorkspace = new Workspaces();
        mockWorkspace.setId(1L);
        mockWorkspace.setName("Desarrollo Cloud");
        mockWorkspace.setDescription("Entorno de pruebas y despliegues");
    }

    @Test
    void testSendWorkspaceEmail_Success() throws Exception {
        // Arrange: Simulamos el comportamiento de las dependencias
        MimeMessage mimeMessageMock = mock(MimeMessage.class);

        when(iWorkspacesService.getById(1L)).thenReturn(mockWorkspace);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessageMock);
        when(templateEngine.process(eq("email-template"), any())).thenReturn("<html>HTML de prueba</html>");

        // Act: Ejecutamos el método que queremos probar
        emailService.sendWorkspaceEmail(requestDto);

        // Assert: Verificamos que los métodos clave hayan sido invocados exactamente las veces esperadas
        verify(iWorkspacesService, times(1)).getById(1L);
        verify(mailSender, times(1)).createMimeMessage();
        verify(mailSender, times(1)).send(any(MimeMessage.class));
    }
}