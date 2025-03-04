package com.mycompany.sipre.controlador;

import com.mycompany.sipre.controlador.db.MySQLConnection;
import com.opencsv.CSVWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class GenerarReportes {
    public static void cargarDatosInventario(DefaultTableModel tableModel) {
        String query = "SELECT " +

                "Tipo_Documento AS tipo_documento, " +
                "Cantidad_Disponible AS cantidad_disponible " +
                "FROM inventario";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Limpiar la tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            // Recorrer los resultados y agregarlos a la tabla
            while (resultSet.next()) {
                Object[] row = {

                        resultSet.getString("tipo_documento"),
                        resultSet.getInt("cantidad_disponible")
                };
                tableModel.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void cargarDatosMovimientos(DefaultTableModel tableModel) {
        String query = "SELECT " +
                "m.ID_Movimiento AS id_movimiento, " +
                "m.Tipo_Movimiento AS tipo_movimiento, " +
                "i.Tipo_Documento AS tipo_documento, " +
                "m.Cantidad AS cantidad, " +
                "m.Fecha AS fecha, " +
                "u.Nombre AS usuario " +
                "FROM movimientos_inventario m " +
                "JOIN inventario i ON m.ID_Inventario = i.ID_Inventario " +
                "JOIN usuarios u ON m.ID_Usuario = u.ID_Usuario";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Limpiar la tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            // Recorrer los resultados y agregarlos a la tabla
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("id_movimiento"),
                        resultSet.getString("tipo_movimiento"),
                        resultSet.getString("tipo_documento"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDate("fecha"),
                        resultSet.getString("usuario")
                };
                tableModel.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}