# PruebaSem9

Proyecto Spring Boot (Maven) para gestionar Autores y Libros usando JPA/Hibernate y PostgreSQL.

Descripción breve
-----------------
Aplicación REST que permite crear, listar, actualizar y eliminar Autores y Libros. Las entidades principales son `Autor` y `Libro` (relación ManyToOne: muchos libros pertenecen a un autor). La aplicación usa capas controlador -> servicio -> repositorio.

Requisitos
----------
- Java 17
- Maven
- PostgreSQL en ejecución (o configurar otro datasource)

Configuración
-------------
1. Editar `src/main/resources/application.properties` con la conexión a la base de datos. Ejemplo mínimo para Postgres:

```ini
spring.datasource.url=jdbc:postgresql://localhost:5432/libreria_bd
spring.datasource.username=postgres
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

Importante: quitar espacios extra alrededor del `=` (p. ej. `spring.jpa.hibernate.ddl-auto= update` está incorrecto).

Ejecutar la aplicación
---------------------
Desde la raíz del proyecto (Windows CMD):

```cmd
mvn spring-boot:run
```

O ejecutar la clase principal `ni.edu.uam.PruebaSem9.PruebaSem9Application` desde el IDE.

Endpoints principales
---------------------
- Autores:
  - GET  /api/autores
  - GET  /api/autores/{id}
  - POST /api/autores
  - PUT  /api/autores/{id}
  - DELETE /api/autores/{id}

- Libros:
  - GET  /api/libros
  - GET  /api/libros/{id}
  - POST /api/libros
  - PUT  /api/libros/{id}
  - DELETE /api/libros/{id}

Ejemplos (Postman)
------------------
Crear autor (Content-Type: application/json):

```json
{
  "nombre": "Juan Pérez",
  "fechaNacimiento": "1990-05-20"
}
```

Crear libro referenciando un autor existente (solo el id dentro del objeto `autor`):

```json
{
  "titulo": "El Quijote",
  "fecha": "1605-01-01",
  "autor": { "id": 1 }
}
```

Problemas comunes
-----------------
- Las tablas no se crean si `spring.jpa.hibernate.ddl-auto` está mal configurado o si la conexión a la base de datos falla. Revisar logs en consola al arrancar.
- Si las entidades no están en paquetes escaneados por Spring Boot, no se detectarán. Asegúrate de que la clase principal esté en un paquete padre común (o usa `@EntityScan` / `scanBasePackages`).
- Evitar usar `@GeneratedValue` en campos `String`; usar `Long`/numéricos para ids autogenerados.

Notas adicionales
-----------------
- Si añadiste validaciones con Bean Validation (por ejemplo para comprobar que el autor sea mayor de 18 años), añade la dependencia `spring-boot-starter-validation` en el `pom.xml` para que las validaciones se apliquen.

Contacto
--------
Proyecto creado localmente por el estudiante. Para dudas, abre un issue o responde a este README con lo que necesites.

