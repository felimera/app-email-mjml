package com.project.app_email_mjml.application.service;

import com.project.app_email_mjml.application.dto.EmailRequestDto;
import com.project.app_email_mjml.domain.models.Workspaces;
import com.project.app_email_mjml.domain.service.IEmailService;
import com.project.app_email_mjml.domain.service.IWorkspacesService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class IEmailServiceImpl implements IEmailService {
    private IWorkspacesService iWorkspacesService;
    private JavaMailSender mailSender;
    private TemplateEngine templateEngine;

    @Autowired
    public IEmailServiceImpl(IWorkspacesService iWorkspacesService, JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.iWorkspacesService = iWorkspacesService;
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Async("taskExecutor")
    @Override
    public void sendWorkspaceEmail(EmailRequestDto request) throws MessagingException {
        // 1. Consultar el área de trabajo en H2 usando el workspaceId
        Workspaces workspace = iWorkspacesService.getById(request.getWorkspaceId());

        // 2. Preparar las variables para la plantilla HTML
        Context context = new Context();
        context.setVariable("fullName", request.getFullName());
        context.setVariable("phone", request.getPhone());
        context.setVariable("userId", request.getId());
        context.setVariable("workspaceName", workspace.getName());
        context.setVariable("workspaceDescription", workspace.getDescription());

        // 3. Procesar la plantilla HTML (generada a partir de MJML)
        String htmlContent = templateEngine.process("email-template", context);

        // 4. Enviar el correo electrónico
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(request.getEmail());
        helper.setSubject("Bienvenido a " + workspace.getName());
        helper.setText(htmlContent, true); // true indica que es HTML

        mailSender.send(message);
    }

}
