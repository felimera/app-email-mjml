package com.project.app_email_mjml.application.service;

import com.project.app_email_mjml.domain.models.Workspaces;
import com.project.app_email_mjml.domain.repository.IWorkspacesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IWorkspacesServiceImplTest {
    @Mock
    private IWorkspacesRepository iWorkspacesRepository;
    @InjectMocks
    private IWorkspacesServiceImpl workspacesService;
    private Workspaces mockWorkspace;

    @BeforeEach
    void setUp() {
        mockWorkspace = new Workspaces();
        mockWorkspace.setId(1L);
        mockWorkspace.setName("Desarrollo Cloud");
        mockWorkspace.setDescription("Entorno de pruebas y despliegues");
    }

    @Test
    void testGetById_Success() {
        // Arrange
        when(iWorkspacesRepository.findById(1L)).thenReturn(Optional.of(mockWorkspace));

        // Act
        Workspaces result = workspacesService.getById(1L);

        // Assert (¡Esto es lo que faltaba!)
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Desarrollo Cloud", result.getName());
        Assertions.assertEquals(1L, result.getId());

        // Verificar que se llamó al repositorio
        verify(iWorkspacesRepository, times(1)).findById(1L);
    }
}