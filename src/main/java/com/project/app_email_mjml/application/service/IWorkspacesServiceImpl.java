package com.project.app_email_mjml.application.service;

import com.project.app_email_mjml.domain.models.Workspaces;
import com.project.app_email_mjml.domain.repository.IWorkspacesRepository;
import com.project.app_email_mjml.domain.service.IWorkspacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IWorkspacesServiceImpl implements IWorkspacesService {

    private IWorkspacesRepository iWorkspacesRepository;

    @Autowired
    public IWorkspacesServiceImpl(IWorkspacesRepository iWorkspacesRepository) {
        this.iWorkspacesRepository = iWorkspacesRepository;
    }

    @Override
    public Workspaces getById(Long id) {
        return iWorkspacesRepository.findById(id).orElseThrow(() -> new RuntimeException("Área de trabajo no encontrada con ID: " + id));
    }
}
