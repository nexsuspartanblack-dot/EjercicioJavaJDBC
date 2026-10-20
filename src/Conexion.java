
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Conexion {

    public static Connection conectar() throws SQLException {
        Properties propiedades = new Properties();

        try (FileInputStream archivo =
                     new FileInputStream("config.properties")) {

            propiedades.load(archivo);

        } catch (IOException e) {
            throw new SQLException(
                "No se pudo leer el archivo config.properties.", e
            );
        }

        String url = propiedades.getProperty("db.url");
        String usuario = propiedades.getProperty("db.user");
        String contrasena = propiedades.getProperty("db.password");

        if (url == null || usuario == null || contrasena == null) {
            throw new SQLException(
                "Faltan datos de conexión en config.properties."
            );
        }

        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
