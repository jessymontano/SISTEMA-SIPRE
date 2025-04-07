package com.mycompany.sipre.controlador;


import com.mycompany.sipre.modelo.Usuario;
import com.mycompany.sipre.controlador.db.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UsuarioDAO {
    public boolean agregarUsuario(String Nombre, String Apellido, String Email, String Contrasena, String Rol) {
        String query = "INSERT INTO sipre.usuarios (Nombre, Apellido, Email, Contrasena, Rol) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, Nombre);
            statement.setString(2, Apellido); // Recuerda hashear la contraseña antes de almacenarla
            statement.setString(3, Email);
            statement.setString(4, Contrasena);
            statement.setString(5, Rol);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean autenticar(String Nombre, String Contrasena) {
        String query = "SELECT * FROM usuarios WHERE Nombre = ? AND Contrasena = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, Nombre);
            statement.setString(2, Contrasena); // Recuerda hashear la contraseña antes de compararla

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Si hay un resultado, el usuario existe

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Usuario getUsuario(String Usuario) {
        String query = "SELECT * FROM usuarios WHERE Nombre = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, Usuario);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getString("Nombre"),
                        resultSet.getString("Apellido"),
                        resultSet.getString("Email"),
                        resultSet.getString("Contrasena"),
                        resultSet.getString("Rol")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Retorna null si no se encuentra el usuario
    }
    // Puedes agregar más métodos aquí, como buscar, actualizar o eliminar usuarios
}


