package com.mycompany.sipre.controlador;


import com.mycompany.sipre.modelo.Usuario;
import com.mycompany.sipre.controlador.db.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UsuarioDAO {
    public boolean agregarUsuario(String username, String password, String fullName, String address, String birthDate, String gender, String email, String role) {
        String query = "INSERT INTO usuarios (username, password, full_name, address, birth_date, gender, email, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password); // Recuerda hashear la contraseña antes de almacenarla
            statement.setString(3, fullName);
            statement.setString(4, address);
            statement.setString(5, birthDate);
            statement.setString(6, gender);
            statement.setString(7, email);
            statement.setString(8, role);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean autenticar(String username, String password) {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password); // Recuerda hashear la contraseña antes de compararla

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Si hay un resultado, el usuario existe

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Usuario getUsuario(String username) {
        String query = "SELECT * FROM usuarios WHERE username = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
                return new Usuario(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("address"),
                        birthDate,
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("role")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Retorna null si no se encuentra el usuario
    }
    // Puedes agregar más métodos aquí, como buscar, actualizar o eliminar usuarios
}


