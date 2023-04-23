package Ejercicio15;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConexionBD conexionBD = new ConexionBD();
        String sql;
        Statement stmt;

//        //Cargar departamentos
//
//        conexionBD.getConexion();
//        sql = "INSERT Departamentos (nombre,descripcion,presupuesto) VALUES ('Logística','Caminos, rutas, gps', 1500000), ('Sistemas','Redes, Pagina web, campus', 2000000), ('Compras','insumos, mantenimeinto', 5000000), ('Tesorería','Nominas', 15000000);";
//        stmt = ConexionBD.getConexion().createStatement();
//        stmt.executeUpdate (sql);
//        ConexionBD.CloseConnection();
//
//        //Cargar empleados
//        conexionBD.getConexion();
//
//        sql = "INSERT Empleados (dni,nombre,apellido,nacionalidad,idDepartamento) VALUES ('3986336','Pedro','Martinez','Argentina','1'), ('4101889','Juan','Valdivia','Chile','2'),('2675936','Karina','Andrada','Argentina','3'),('2015345','Oscar','Flores','Peru','1');";
//        stmt = ConexionBD.getConexion().createStatement();
//        stmt.executeUpdate (sql);
//        ConexionBD.CloseConnection();
//
//        //Modificar nacionalidad empleado
//        conexionBD.getConexion();
//
//        sql = "UPDATE Empleados SET nacionalidad = 'Brasil' WHERE id = 1;";
//        stmt = ConexionBD.getConexion().createStatement();
//        stmt.executeUpdate (sql);
//        ConexionBD.CloseConnection();
//
//        //Eliminar un departamento
//        conexionBD.getConexion();
//
//        sql = "DELETE FROM Departamentos WHERE id = 4;";
//        stmt = ConexionBD.getConexion().createStatement();
//        stmt.executeUpdate (sql);
//        ConexionBD.CloseConnection();

        //Mostrar empleados del departamento logistica
        conexionBD.getConexion();

        System.out.println("Empleados de Logistica");
        sql = "SELECT empleados.id,empleados.dni,empleados.nombre, empleados.apellido, empleados.nacionalidad FROM empleados,departamentos WHERE departamentos.id = idDepartamento AND departamentos.nombre = 'logistica';";
        stmt = ConexionBD.getConexion().createStatement();
        ResultSet resultSet = stmt.executeQuery (sql);

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t");
        }
        ConexionBD.CloseConnection();


        //Mostrar departamentos ordenados alfabéticamente
        conexionBD.getConexion();


        System.out.println("Departamentos");
        sql = "SELECT * FROM departamentos ORDER BY nombre;";
        stmt = ConexionBD.getConexion().createStatement();
        resultSet = stmt.executeQuery (sql);

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getBigDecimal(4));
        }
        ConexionBD.CloseConnection();
    }
}
