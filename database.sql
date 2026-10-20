
-- Base de datos para el sistema de gestion de productos
CREATE DATABASE IF NOT EXISTS ejercicio_productos;

USE ejercicio_productos;

-- Tabla para almacenar los productos
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL
);
