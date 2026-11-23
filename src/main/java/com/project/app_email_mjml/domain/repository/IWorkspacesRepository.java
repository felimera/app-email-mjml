package com.project.app_email_mjml.domain.repository;

import com.project.app_email_mjml.domain.models.Workspaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorkspacesRepository extends JpaRepository<Workspaces, Long> {
}
