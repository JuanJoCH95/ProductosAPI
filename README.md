# Productos API

Este es un proyecto backend de un sistema para la gestión de inventario de productos, usuarios y proveedores (consultar, registrar, editar y eliminar). Se comunica con el Frontend a través de API REST; también cuenta con login de autenticación para el consumo de las API. El proyecto está construido en Spring Boot con Java 17, cuenta con Spring Security, JPA para la persistencia de datos (base de datos en MySQL) y Maven para la gestión de dependencias. El IDE utilizado para la creación del proyecto fue IntelliJ IDEA.

## Códigos de respuesta en el Entity Response para el status HTTP 200:
- 1: Resultado exitoso
- 2: Datos no encontrados
- 3: Datos incompletos
- 4: Datos ya existentes