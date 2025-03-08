package com.mycompany.sipre.controlador;
import com.mycompany.sipre.controlador.db.MySQLConnection;
import com.mycompany.sipre.modelo.Solicitud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Solicitud> buscarSolicitudesPorTipo(String tipoDocumento) {
        String sql = "SELECT * FROM sipre.solicitud WHERE TipoDocumento = ?";
        List<Solicitud> solicitudes = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, tipoDocumento); // Establece el tipo de documento en la consulta
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // Usamos while para recorrer todas las coincidencias
                Solicitud solicitud = new Solicitud();
                solicitud.setFolio(rs.getInt("Folio"));
                solicitud.setTipoDocumento(rs.getString("TipoDocumento"));
                solicitud.setFecha(rs.getDate("Fecha_Solicitud"));
                solicitud.setMotivo(rs.getString("Motivo"));

                solicitudes.add(solicitud);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitudes; // Retorna la lista de solicitudes
    }

    public List<Solicitud> buscarSolicitudPorMesAnio(int anio, int mes) {
        String sql = "SELECT * FROM sipre.solicitud WHERE YEAR(Fecha_Solicitud) = ? AND MONTH(Fecha_Solicitud) = ?";
        List<Solicitud> solicitudes = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, anio);
            stmt.setInt(2, mes);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Solicitud solicitud = new Solicitud();
                solicitud.setFolio(rs.getInt("Folio"));
                solicitud.setTipoDocumento(rs.getString("TipoDocumento"));
                solicitud.setFecha(rs.getDate("Fecha_Solicitud"));
                solicitud.setMotivo(rs.getString("Motivo"));
                solicitudes.add(solicitud);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }
    
    public List<Solicitud> obtenerSolicitudes() {
        String sql = "SELECT * FROM sipre.solicitud";
        List<Solicitud> solicitudes = new ArrayList<>();
        
        try (Connection connection = MySQLConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                  ResultSet rs = stmt.executeQuery();
                  while (rs.next()) {
                      Solicitud solicitud = new Solicitud();
                      solicitud.setFolio(rs.getInt("Folio"));
                      solicitud.setTipoDocumento(rs.getString("TipoDocumento"));
                      solicitud.setFecha(rs.getDate("Fecha_Solicitud"));
                      solicitud.setMotivo(rs.getString("Motivo"));
                      solicitudes.add(solicitud);
                  }
                  
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        return solicitudes;
    }
    
    public boolean actualizarSolicitud(Solicitud solicitud) {
        String sql = "UPDATE sipre.solicitud SET TipoDocumento = ?, Fecha_Solicitud = ?, Motivo = ? WHERE Folio = ?";
         try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
             
             java.sql.Date sqlDate = new java.sql.Date(solicitud.getFecha().getTime());
             
             stmt.setString(1, solicitud.getTipoDocumento());
             stmt.setDate(2, sqlDate);
             stmt.setString(3, solicitud.getMotivo());
             stmt.setInt(4, solicitud.getFolio());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se actualizo la solicitud

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

