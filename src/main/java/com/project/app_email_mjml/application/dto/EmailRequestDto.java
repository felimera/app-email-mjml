package com.project.app_email_mjml.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDto {
    private String email;
    private Long id;
    private String fullName;
    private String phone;
    private Long workspaceId;
}
