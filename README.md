## 📌 Descripción
Sistema backend para gestión de registros estudiantiles universitarios con operaciones CRUD.

## 🛠 Tecnologías
- **Backend**: Java 17 + Spring Boot 3.4.3
- **Base de Datos**: PostgreSQL 15
- **ORM**: Spring Data JPA/Hibernate
- **Documentación**: Swagger/OpenAPI 2.5.0
- **Herramientas**: Lombok, Maven

## 🚀 Instalación
1. Clonar repositorio:
```bash
git clone https://github.com/tu-usuario/registro-universitario.git
cd registro-universitario
```

## Configurar PostgreSQL:

```
Crear DB: registro_universitario
Editar src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/registro_universitario
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

## Ejecutar:

```bash
mvn clean install
mvn spring-boot:run
```

## 📚 Endpoints

Accede a la documentación interactiva:

-  Swagger UI: http://localhost:8080/swagger-ui.html

-  OpenAPI: http://localhost:8080/v3/api-docs

## 🏗 Estructura

```
src/
├── main/
│   ├── java/com/universidad/
│   │   ├── controller/      # REST endpoints
│   │   ├── dto/            # Data Transfer Objects  
│   │   ├── model/          # Entidades JPA
│   │   ├── repository/     # Spring Data interfaces
│   │   ├── service/        # Lógica de negocio
│   │   └── validation/     # Manejo de errores
│   └── resources/          # Configuración
```

## 🌟 Características Principales

- Gestión Completa de Estudiantes: CRUD completo para registros estudiantiles

- Validación de Datos: Validación automática de entradas

- Documentación API Automática: Generada con Swagger/OpenAPI

- Arquitectura Limpia: Separación clara de capas (Controller-Service-Repository)

- DTO Pattern: Uso de Data Transfer Objects para transferencia de datos

- Manejo Centralizado de Errores: Respuestas de error estandarizadas

## 🤝 Contribución
Si deseas contribuir al proyecto:

- Haz un fork del repositorio

- Crea una rama para tu feature (git checkout -b feature/awesome-feature)

- Haz commit de tus cambios (git commit -m 'Add some awesome feature')

- Haz push a la rama (git push origin feature/awesome-feature)

- Abre un Pull Request

## 

Desarrollado con ❤️ por Jose Aruquipa | 2025
