
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ProductoDAO productoDAO = new ProductoDAO();
        int opcion;

        do {
            System.out.println("\n===== GESTION DE PRODUCTOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Consultar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Precio del producto: ");
                    double precio = teclado.nextDouble();

                    System.out.print("Cantidad disponible: ");
                    int cantidad = teclado.nextInt();
                    teclado.nextLine();

                    if (nombre.trim().isEmpty()
                            || precio < 0
                            || cantidad < 0) {

                        System.out.println("Error: ingrese datos validos.");

                    } else {
                        Producto producto = new Producto(
                            nombre, precio, cantidad
                        );

                        if (productoDAO.registrarProducto(producto)) {
                            System.out.println(
                                "Producto registrado correctamente."
                            );
                        } else {
                            System.out.println(
                                "No se pudo registrar el producto."
                            );
                        }
                    }
                    break;

                case 2:
                    productoDAO.consultarProductos();
                    break;

                case 3:
                    System.out.print("ID del producto a actualizar: ");
                    int idActualizar = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = teclado.nextLine();

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = teclado.nextDouble();

                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = teclado.nextInt();
                    teclado.nextLine();

                    if (nuevoNombre.trim().isEmpty()
                            || nuevoPrecio < 0
                            || nuevaCantidad < 0) {

                        System.out.println("Datos no validos.");

                    } else {
                        Producto producto = new Producto(
                            idActualizar,
                            nuevoNombre,
                            nuevoPrecio,
                            nuevaCantidad
                        );

                        if (productoDAO.actualizarProducto(producto)) {
                            System.out.println(
                                "Producto actualizado correctamente."
                            );
                        } else {
                            System.out.println(
                                "No se encontro el producto."
                            );
                        }
                    }
                    break;

                case 4:
                    System.out.print("ID del producto a eliminar: ");
                    int idEliminar = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print(
                        "¿Seguro que desea eliminarlo? (s/n): "
                    );
                    String confirmacion = teclado.nextLine();

                    if (confirmacion.equalsIgnoreCase("s")) {

                        if (productoDAO.eliminarProducto(idEliminar)) {
                            System.out.println(
                                "Producto eliminado correctamente."
                            );
                        } else {
                            System.out.println(
                                "No se encontro el producto."
                            );
                        }

                    } else {
                        System.out.println("Operacion cancelada.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}
