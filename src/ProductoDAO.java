
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    // Registrar un producto
    public boolean registrarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, cantidad) VALUES (?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setDouble(2, producto.getPrecio());
            sentencia.setInt(3, producto.getCantidad());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar el producto: " + e.getMessage());
            return false;
        }
    }

    // Consultar todos los productos
    public void consultarProductos() {
        String sql = "SELECT * FROM productos";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            System.out.println("\n===== LISTA DE PRODUCTOS =====");

            boolean hayProductos = false;

            while (resultado.next()) {
                Producto producto = new Producto(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getDouble("precio"),
                    resultado.getInt("cantidad")
                );

                System.out.println("ID: " + producto.getId());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Cantidad: " + producto.getCantidad());
                System.out.println("-----------------------------");

                hayProductos = true;
            }

            if (!hayProductos) {
                System.out.println("No hay productos registrados.");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar productos: " + e.getMessage());
        }
    }

    // Actualizar un producto
    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE id = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setDouble(2, producto.getPrecio());
            sentencia.setInt(3, producto.getCantidad());
            sentencia.setInt(4, producto.getId());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    // Eliminar un producto por su ID
    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, id);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }
}
