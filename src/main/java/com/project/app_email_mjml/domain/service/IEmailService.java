package com.project.app_email_mjml.domain.service;

import com.project.app_email_mjml.application.dto.EmailRequestDto;
import jakarta.mail.MessagingException;

public interface IEmailService {
    void sendWorkspaceEmail(EmailRequestDto request) throws MessagingException;
}
