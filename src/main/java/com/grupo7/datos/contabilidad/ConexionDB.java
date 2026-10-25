package com.grupo7.datos.contabilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "******";
    private static final String USUARIO = "*****";
    private static final String PASSWORD = "*****";

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
