# Contacts API

Este repositorio contiene un sistema de **gestión de contactos** donde los usuarios pueden consultar, crear, actualizar y eliminar contactos. El proyecto está construido con **Java** y **Spring Boot** y utiliza **Swagger** para la documentación de la API y **JUnit** para las pruebas unitarias.

## Descripción del Proyecto

Este proyecto proporciona una API para gestionar los contactos de los usuarios. Los usuarios pueden agregar, actualizar, eliminar y consultar información sobre sus contactos. Además, se incluye una funcionalidad para obtener información detallada de cada contacto.

## Requisitos

- Java 17 (o superior)
- Spring Boot
- Maven (o Gradle)
- Base de datos (H2, MySQL, PostgreSQL, o cualquier base de datos relacional)
- Swagger (para la documentación de la API)
- JUnit (para las pruebas unitarias)

## Instalación

1. **Clonar el repositorio**

   ```bash
   git clone https://github.com/tuusuario/contacts-api.git
   cd contacts-api
Instalar las dependencias

Si usas Maven:

bash
Copiar
Editar
mvn install
O si prefieres Gradle:

bash
Copiar
Editar
gradle build
Ejecutar la aplicación

Usando Maven:

bash
Copiar
Editar
mvn spring-boot:run
Usando Gradle:

bash
Copiar
Editar
gradle bootRun
Ya corriendo, puedes revisar la documentación Swagger

Accede a la documentación interactiva en:

bash
Copiar
Editar
http://localhost:8080/swagger-ui.html
Arquitectura del Sistema
Modelo de Datos
El sistema tiene modelos para Contactos y Usuarios. Cada contacto tiene atributos como nombre, correo electrónico, número de teléfono y dirección. Los usuarios pueden realizar operaciones CRUD sobre sus contactos.

Patrón de Diseño
Utiliza un patrón MVC (Modelo-Vista-Controlador) para separar la lógica de negocio de la presentación y la manipulación de datos.

Funciones Clave

Crear, consultar, actualizar y eliminar contactos.
Consultar la información detallada de un contacto.
Ver la lista de contactos asociados a un usuario.
Colección de APIs
Puedes importar esta colección de APIs en tu entorno de desarrollo utilizando Postman para probar todas las funcionalidades de la API.

Importa la colección de Postman aquí

Pruebas
El proyecto incluye pruebas unitarias utilizando JUnit para garantizar la calidad del código. Puedes ejecutar las pruebas con:

bash
Copiar
Editar
mvn test
o

bash
Copiar
Editar
gradle test
Contribuir
Las contribuciones son bienvenidas. Si tienes alguna idea para mejorar el proyecto, abre un issue o crea un pull request.
