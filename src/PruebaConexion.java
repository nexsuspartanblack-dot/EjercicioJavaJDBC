import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {

        try (Connection conexion = Conexion.conectar()) {

            System.out.println("¡Conexión exitosa con MySQL!");
            System.out.println("Base de datos: ejercicio_productos");

        } catch (SQLException e) {

            System.out.println("Error al conectar con MySQL:");
            System.out.println(e.getMessage());

        }
    }
}
