package Ejercicio15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static Connection conexion;

    public static Connection getConexion() throws SQLException {

        if (conexion == null || conexion.isClosed()){
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qatar2022","root","");
        }

        return conexion;
    }

    public static void CloseConnection() throws SQLException{
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }
}
