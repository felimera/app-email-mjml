
# **🚀 API de Envío de Notificaciones por Correo Electrónico (MJML & Thymeleaf)**

Backend desarrollado en Spring Boot diseñado para procesar plantillas de correo electrónico altamente estilizadas utilizando MJML y Thymeleaf, con envío asíncrono, gestión de áreas de trabajo (Workspaces) con base de datos H2, adjuntos en PDF y documentación interactiva mediante OpenAPI/Swagger.

### 🛠️ Tecnologías y Herramientas Utilizadas

* Java 17
* Spring Boot (Web, Mail, Thymeleaf, Data JPA)
* Base de Datos H2 (En memoria)
* Thymeleaf & MJML (Para diseño y motor de plantillas HTML responsivas)
* Springdoc OpenAPI / Swagger UI (Documentación de endpoints)
* JUnit 5 & Mockito (Pruebas unitarias aisladas)
* Lombok (Reducción de código repetitivo)

### 📂 Estructura Principal del Proyecto
```text
src/
├── main/
│   ├── java/com/project/app_email_mjml/
│   │   ├── controller/            # Controladores REST (Endpoints y Swagger)
│   │   ├── dto/                   # Objetos de transferencia de datos (DTOs y validaciones)
│   │   ├── model/                 # Entidades JPA (Workspaces, etc.)
│   │   ├── repository/            # Repositorios de acceso a datos
│   │   └── service/               # Lógica de negocio (Envío de correos y gestión)
│   └── resources/
│       ├── templates/             # Plantillas HTML procesadas con Thymeleaf
│       └── application.properties # Configuración del servidor, correo y base de datos
└── test/                          # Pruebas unitarias (Servicios, Controladores y Repositorios)
```
### ✨ Características Principales

1. Plantillas Dinámicas con MJML / Thymeleaf: Permite personalizar correos electrónicos profesionales y adaptables a dispositivos móviles inyectando variables dinámicas (Nombre, Teléfono, Descripción del Workspace, Preview/Preheader).
2. Envío Asíncrono (@Async): Las peticiones de correo se procesan en segundo plano para no bloquear el hilo de respuesta de la API HTTP.
3. Archivos Adjuntos: Soporte multipart (MimeMessageHelper) para enviar documentos adjuntos (como reportes en PDF generados o simulados).
4. Documentación Interactiva (Swagger UI): Endpoints documentados con anotaciones de OpenAPI para una fácil visualización y pruebas visuales.
5. Pruebas Unitarias Robustas: Cobertura de pruebas con JUnit 5 y Mockito para controladores y servicios de forma totalmente aislada.

### 🔌 Documentación de Endpoints (Swagger)

Una vez que ejecutes la aplicación, puedes acceder a la interfaz interactiva de Swagger UI en tu navegador:

* URL de Swagger: `http://localhost:8080/swagger-ui/index.html`

### Endpoint de Envío de Correo

* **URL:** POST `/api/emails/send`
* **Descripción:** Recibe los datos del usuario y del área de trabajo, procesa la plantilla y envía el correo con el PDF adjunto de manera asíncrona.
* **Ejemplo de Payload (JSON):**
```json
{
  "id": 1,
  "fullName": "Carlos Pérez",
  "email": "carlos.test@example.com",
  "phone": "+57 3001234567",
  "workspaceId": 1
}
```

### 🧪 Ejecución de Pruebas Unitarias

Para ejecutar todas las pruebas unitarias del proyecto de manera limpia desde la terminal integrada de tu IDE, utiliza Maven:
```bash
mvn test
```

### ⚙️ Configuración del Entorno (application.properties)

Asegúrate de configurar tus credenciales de servidor SMTP (como Gmail o Mailtrap) en el archivo application.properties para el envío real de correos:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=tu-correo@gmail.com
spring.mail.password=tu-contraseña-de-aplicacion
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```