package com.mycompany.sipre.controlador;

import com.mycompany.sipre.controlador.db.MySQLConnection;
import com.mycompany.sipre.modelo.Documento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDAO {

    public boolean agregarDocumento(int Folio, String TipoDocumento, String Estatus, int CantidadDocumentos) {
        String query = "INSERT INTO sipre.documentos (Folio, TipoDocumento, Estatus, CantidadDocumentos) VALUES (?, ?, ?, ?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, Folio);
            statement.setString(2, TipoDocumento);
            statement.setString(3, Estatus);
            statement.setInt(4, CantidadDocumentos);

            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Documento> buscarDocumentosPorEstatus(String estatus) {
        String sql = "SELECT d.Folio, d.TipoDocumento, d.Estatus, d.CantidadDocumentos, s.Fecha_Solicitud, s.Motivo FROM sipre.documentos d LEFT JOIN sipre.solicitud s ON d.Folio = s.Folio WHERE Estatus = ?";
        List<Documento> documentos = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, estatus);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Documento documento = new Documento();
                documento.setFolio(rs.getInt("Folio"));
                documento.setTipoDocumento(rs.getString("TipoDocumento"));
                documento.setEstatus(rs.getString("Estatus"));
                documento.setCantidadDocumentos(rs.getInt("CantidadDocumentos"));
                documento.setFecha(rs.getDate("Fecha_Solicitud"));
                documento.setMotivo(rs.getString("Motivo"));

                documentos.add(documento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return documentos;
    }

    public Documento buscarDocumentoPorFolio(int folio) {
        String sql = "SELECT d.Folio, d.TipoDocumento, d.Estatus, d.CantidadDocumentos, s.Fecha_Solicitud, s.Motivo " +
                "FROM sipre.documentos d " +
                "LEFT JOIN sipre.solicitud s ON d.Folio = s.Folio " +
                "WHERE d.Folio = ?";
        Documento documento = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, folio); // Establece el folio en la consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Si se encuentra el documento, crea el objeto Documento
                documento = new Documento();
                documento.setFolio(rs.getInt("Folio"));
                documento.setTipoDocumento(rs.getString("TipoDocumento"));
                documento.setEstatus(rs.getString("Estatus"));
                documento.setCantidadDocumentos(rs.getInt("CantidadDocumentos"));

                // Si hay datos en la tabla solicitud, asigna los valores de Fecha y Motivo
                if (rs.getDate("Fecha_Solicitud") != null) {
                    documento.setFecha(rs.getDate("Fecha_Solicitud"));
                }
                if (rs.getString("Motivo") != null) {
                    documento.setMotivo(rs.getString("Motivo"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documento; // Retorna el documento encontrado (o null si no se encontró)
    }

    public List<Documento> buscarDocumentosPorTipo(String tipoDocumento) {
        // Consulta SQL para obtener los documentos filtrados por TipoDocumento
        String sql = "SELECT d.Folio, d.TipoDocumento, d.Estatus, d.CantidadDocumentos, s.Fecha_Solicitud, s.Motivo " +
                "FROM sipre.documentos d " +
                "LEFT JOIN sipre.solicitud s ON d.Folio = s.Folio " +
                "WHERE d.TipoDocumento = ?";  // Filtramos por TipoDocumento
        List<Documento> documentos = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, tipoDocumento); // Establece el tipo de documento en la consulta
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // Recorremos todas las coincidencias
                Documento documento = new Documento();
                documento.setFolio(rs.getInt("Folio"));
                documento.setTipoDocumento(rs.getString("TipoDocumento"));
                documento.setEstatus(rs.getString("Estatus"));
                documento.setCantidadDocumentos(rs.getInt("CantidadDocumentos"));

                // Si hay datos en la tabla solicitud, asignamos los valores de Fecha y Motivo
                if (rs.getDate("Fecha_Solicitud") != null) {
                    documento.setFecha(rs.getDate("Fecha_Solicitud"));
                }
                if (rs.getString("Motivo") != null) {
                    documento.setMotivo(rs.getString("Motivo"));
                }

                documentos.add(documento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documentos; // Retorna la lista de documentos
    }
    
    public List<Documento> obtenerDocumentos() {
        String sql = "SELECT * FROM sipre.documentos";
        List<Documento> documentos = new ArrayList<>();
        
        try (Connection connection = MySQLConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Documento documento = new Documento();
                documento.setFolio(rs.getInt("Folio"));
                documento.setTipoDocumento(rs.getString("TipoDocumento"));
                documento.setEstatus(rs.getString("Estatus"));
                documento.setCantidadDocumentos(rs.getInt("CantidadDocumentos"));
                
            documentos.add(documento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documentos;
    }
    
    public boolean actualizarDocumento(Documento documento, int folioAnterior) {
        String sql = "UPDATE sipre.documentos SET Folio = ?, TipoDocumento = ?, CantidadDocumentos = ? WHERE Folio = ?";
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, documento.getFolio());
            stmt.setString(2, documento.getTipoDocumento());
            stmt.setInt(3, documento.getCantidadDocumentos());
            stmt.setInt(4, folioAnterior);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se actualizo la documento

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarDocumento(int folio) {
        String sql = "DELETE FROM sipre.documentos WHERE Folio = ?";
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, folio);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se actualizo la documento

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

