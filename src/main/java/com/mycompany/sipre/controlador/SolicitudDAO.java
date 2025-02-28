package com.mycompany.sipre.controlador;
import com.mycompany.sipre.controlador.db.MySQLConnection;
import com.mycompany.sipre.modelo.Solicitud;

import java.sql.*;

public class SolicitudDAO {

    public boolean agregarSolicitud(int Folio, String TipoDocumento, java.util.Date Fecha_Solicitud, String Motivo) {
        String query = "INSERT INTO sipre.solicitud (Folio, TipoDocumento, Fecha_Solicitud, Motivo) VALUES (?, ?, ?, ?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Convertir java.util.Date a java.sql.Date si es necesario
            java.sql.Date sqlDate = new java.sql.Date(Fecha_Solicitud.getTime());

            statement.setInt(1, Folio);
            statement.setString(2, TipoDocumento);
            statement.setDate(3, sqlDate);  // Establecer la fecha convertida
            statement.setString(4, Motivo);

            int filasInsertadas = statement.executeUpdate(); // Ejecutar la inserción
            return filasInsertadas > 0; // Retorna true si se insertó al menos 1 fila

        } catch (SQLException e) {
            e.printStackTrace();  // Considera registrar el error o lanzar una excepción personalizada
            return false; // Retorna false si hubo un error
        }
    }
    public boolean cancelarSolicitud(int folio) {
        String sql = "DELETE FROM sipre.solicitud WHERE Folio = ?";  // Corregí el nombre de la tabla y la columna

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, folio);  // Utilizo 'int' para el folio

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se eliminó la solicitud

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Solicitud buscarSolicitud(int folio) {
        String sql = "SELECT * FROM sipre.solicitud WHERE Folio = ?";
        Solicitud solicitud = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, folio); // Establece el valor del folio en la consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Si encuentra la solicitud, la crea y asigna sus valores
                solicitud = new Solicitud();
                solicitud.setFolio(rs.getInt("Folio"));
                solicitud.setTipoDocumento(rs.getString("TipoDocumento"));
                solicitud.setFecha(rs.getDate("Fecha_Solicitud"));
                solicitud.setMotivo(rs.getString("Motivo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return solicitud; // Retorna la solicitud o null si no la encuentra
    }



}

