package com.grupo7.datos.contabilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
    private static final String USUARIO = "GRUPO7";
    private static final String PASSWORD = "Admin1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

//Cerramos la conexion
    public static void closeConnection(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error en la conexion" + e.getMessage());
            }
        }
    }

//Verificamos la conexion 
    public static void main(String[] args) {
        try (Connection conexion = getConnection()) {
            System.out.println("Conexion realizada");
        } catch (SQLException e) {
            System.err.println("Error en la conexion" + e.getMessage());
        }
    }

}
