/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

/*Paso #5: Importando los paquetes
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Paso #6: Cargando el controlador en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            return; // Se Sale si el controlador no se carga
        }
        
        // Paso 7: Establecer la cadena de conexión
        String url = "jdbc:mysql://localhost:3306/barber_time";
        String usuario = "root";
        String contraseña = "Jenner1234";
        
        // Paso 8: Establecer una conexión
        try {
            Connection conexion = DriverManager.getConnection(url,
            usuario, contraseña);
            try {
                Statement statement = conexion.createStatement();
                        
                // Ejemplo de Consulta de Selección (SELECT)
                String consultaSelect = "SELECT id_admin, nombre FROM administrador";
                try {
                    ResultSet resultado = statement.executeQuery(consultaSelect);

                    // Procesar los resultados de la consulta
                    while (resultado.next()) {
                        int valorid_admin = resultado.getInt("id_admin");
                        String valornombre = resultado.getString("nombre");

                        // Imprimir los resultados o procesarlos de otra manera
                        System.out.println("id_admin: " + valorid_admin + ", nombre: " + valornombre);
                    }

                } catch (SQLException e) {
                    System.out.println("Error en la consulta SELECT: " + e.getMessage());
                }
                
                 // Ejemplo de Consulta de Insertar (INSERT)
                String consultaInsert = "INSERT INTO administrador "
                        + "(id_admin, celular, correo, nombre, cargo, idservicio, idproducto) VALUES"
                        + " (45, 3216272897, 'jperez@gmail.com','Juan Perez', 'Admin3', 1, 1)";
                try {
                    int filasAfectadas = statement.executeUpdate(consultaInsert);
                    System.out.println("Filas insertadas: " + filasAfectadas);
                } catch (SQLException e) {
                    System.out.println("Error en la consulta INSERT: " + e.getMessage());
                }

            } catch (SQLException e) {
            }
            
            // Cerrar la conexión
            try {
                conexion.close();
            } catch (SQLException e) {
            }
            
        } catch (SQLException e) {
        }
    }
    
}
