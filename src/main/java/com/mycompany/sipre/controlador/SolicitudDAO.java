package com.mycompany.sipre.controlador;
import com.mycompany.sipre.controlador.db.MySQLConnection;
import com.mycompany.sipre.modelo.Solicitud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDAO {

    public boolean agregarSolicitud(int Folio, String TipoDocumento, java.util.Date Fecha_Solicitud, String Motivo) {
        // Consulta para verificar si el folio existe en la tabla de documentos
        String queryBusquedaFolio = "SELECT COUNT(*) FROM sipre.documentos WHERE Folio = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmtBusqueda = connection.prepareStatement(queryBusquedaFolio)) {

            // Establecer el valor del folio en la consulta de búsqueda
            stmtBusqueda.setInt(1, Folio);
            ResultSet rs = stmtBusqueda.executeQuery();

            // Verificar si el folio existe
            if (rs.next() && rs.getInt(1) > 0) {
                // El folio existe, primero verificamos el estatus actual
                String queryEstatus = "SELECT Estatus FROM sipre.documentos WHERE Folio = ?";
                try (PreparedStatement stmtEstatus = connection.prepareStatement(queryEstatus)) {
                    stmtEstatus.setInt(1, Folio);
                    ResultSet rsEstatus = stmtEstatus.executeQuery();

                    if (rsEstatus.next()) {
                        String estatusActual = rsEstatus.getString("Estatus");
                        if ("Solicitado".equals(estatusActual)) {
                            System.out.println("El folio ya tiene el estatus 'Solicitado'.");
                            return false; // No se actualiza si ya está solicitado
                        }
                    }

                    // El folio no tiene el estatus 'Solicitado', ahora podemos insertar en la tabla solicitud
                    String queryInsert = "INSERT INTO sipre.solicitud (Folio, TipoDocumento, Fecha_Solicitud, Motivo) VALUES (?, ?, ?, ?)";

                    try (PreparedStatement stmtInsert = connection.prepareStatement(queryInsert)) {
                        // Convertir java.util.Date a java.sql.Date si es necesario
                        java.sql.Date sqlDate = new java.sql.Date(Fecha_Solicitud.getTime());

                        stmtInsert.setInt(1, Folio);
                        stmtInsert.setString(2, TipoDocumento);
                        stmtInsert.setDate(3, sqlDate);  // Establecer la fecha convertida
                        stmtInsert.setString(4, Motivo);

                        int filasInsertadas = stmtInsert.executeUpdate(); // Ejecutar la inserción
                        if (filasInsertadas > 0) {
                            // Si la inserción fue exitosa, actualizar el estatus del folio en documentos
                            String queryUpdateEstatus = "UPDATE sipre.documentos SET Estatus = 'Solicitado' WHERE Folio = ?";

                            try (PreparedStatement stmtUpdate = connection.prepareStatement(queryUpdateEstatus)) {
                                stmtUpdate.setInt(1, Folio);
                                int filasActualizadas = stmtUpdate.executeUpdate(); // Ejecutar la actualización del estatus
                                return filasActualizadas > 0; // Retorna true si el estatus fue actualizado correctamente
                            }
                        }
                        return false; // Si no se insertó en la tabla solicitud, retornamos false
                    }
                }

            } else {
                // El folio no existe en la tabla documentos, manejar el error
                System.out.println("El folio no existe en la tabla documentos.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En caso de error en la conexión o ejecución
        }
    }

    public boolean cancelarSolicitud(int folio) {
        String sqlEliminarSolicitud = "DELETE FROM sipre.solicitud WHERE Folio = ?";  // Eliminar solicitud
        String sqlActualizarEstatus = "UPDATE sipre.documentos SET Estatus = 'En bodega' WHERE Folio = ?";  // Actualizar estatus en documentos

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmtEliminar = connection.prepareStatement(sqlEliminarSolicitud);
             PreparedStatement stmtActualizarEstatus = connection.prepareStatement(sqlActualizarEstatus)) {

            // Eliminar la solicitud
            stmtEliminar.setInt(1, folio);  // Establecer el folio
            int filasAfectadas = stmtEliminar.executeUpdate();

            if (filasAfectadas > 0) {
                // Si se eliminó la solicitud, actualizar el estatus del documento
                stmtActualizarEstatus.setInt(1, folio);
                int filasActualizadas = stmtActualizarEstatus.executeUpdate();

                // Si el estatus fue actualizado correctamente, retorna true
                return filasActualizadas > 0;
            } else {
                return false; // No se eliminó la solicitud
            }

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

    public String obtenerTipoDocumentoPorFolio(int folio) {
        String query = "SELECT TipoDocumento FROM sipre.documentos WHERE Folio = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, folio);  // Establece el folio en el query

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("TipoDocumento");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;  // Si no se encuentra el folio, retorna null
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

