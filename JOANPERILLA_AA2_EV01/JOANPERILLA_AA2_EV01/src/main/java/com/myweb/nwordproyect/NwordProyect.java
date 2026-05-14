/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myweb.nwordproyect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class NwordProyect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/nword_proyect";
            String user = "root";
            String password = "";

            try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()
            ) {
                // INSERTAR un usuario
                stmt.execute("INSERT INTO usuarios (id, nombre) VALUES (NULL, 'valeria');");
                System.out.println("Usuario insertado en la base de datos");

                try ( // CONSULTAR usuarios
                        ResultSet rs = stmt.executeQuery("SELECT id, nombre FROM usuarios")) {
                    System.out.println("Lista de usuarios:");
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nombre = rs.getString("nombre");
                        System.out.println("ID: " + id + " | Nombre: " + nombre);
                    }
                    
                    // ACTUALIZAR un usuario
                    int filasActualizadas = stmt.executeUpdate("UPDATE usuarios SET nombre = '' WHERE nombre = ''");
                    System.out.println("Usuarios actualizados: " + filasActualizadas);
                    
                    // ELIMINAR un usuario
                    int filasEliminadas = stmt.executeUpdate("DELETE FROM usuarios WHERE nombre = ' actualizado'");
                    System.out.println("Usuarios eliminados: " + filasEliminadas);
                }
            }
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se encontró el driver JDBC de MySQL");
        }
    }
}
