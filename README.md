# Sistema de Gestión de Productos

## 1. Descripción del proyecto

Aplicación de consola desarrollada en Java que permite gestionar productos mediante operaciones CRUD (crear, consultar, actualizar y eliminar), utilizando una base de datos MySQL.

## 2. Objetivo

Aplicar los conceptos de programación en Java, conexión a bases de datos mediante JDBC y control de versiones con Git.

## 3. Tecnologías utilizadas

- Java
- JDBC (Java Database Connectivity)
- MySQL 8
- MySQL Connector/J
- Visual Studio Code
- Git

## 4. Funcionalidades

- Registrar productos con nombre, precio y cantidad.
- Consultar los productos registrados.
- Actualizar la información de un producto mediante su ID.
- Eliminar productos mediante su ID, previa confirmación.
- Validar algunos datos ingresados por el usuario.

## 5. Estructura del proyecto

- `Conexion.java`: administra la conexión con MySQL.
- `Producto.java`: representa la información de cada producto.
- `ProductoDAO.java`: contiene las operaciones de acceso a datos.
- `Main.java`: presenta el menú principal.
- `PruebaConexion.java`: permite comprobar la conexión a la base de datos.
- `lib/`: contiene el controlador JDBC de MySQL.
- `.vscode/`: contiene la configuración del proyecto en Visual Studio Code.

## 6. Base de datos

La aplicación utiliza la base de datos `ejercicio_productos` y la tabla `productos`, con los campos:

- `id`: identificador del producto.
- `nombre`: nombre del producto.
- `precio`: precio del producto.
- `cantidad`: cantidad disponible.

## 7. Configuración

Se requiere tener instalado Java, MySQL Server y el controlador MySQL Connector/J.

Las credenciales de conexión se configuran localmente en `config.properties`. Este archivo no debe publicarse ni incluirse en el repositorio.

## 8. Control de versiones

El proyecto utiliza Git para registrar las versiones y los cambios realizados durante el desarrollo.