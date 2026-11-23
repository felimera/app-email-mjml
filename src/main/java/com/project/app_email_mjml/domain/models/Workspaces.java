package com.project.app_email_mjml.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_workspaces")
public class Workspaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wor_id")
    private Long id;
    @Column(name = "wor_name", columnDefinition = "TEXT")
    private String name;
    @Column(name = "wor_description", columnDefinition = "TEXT")
    private String description;
}
