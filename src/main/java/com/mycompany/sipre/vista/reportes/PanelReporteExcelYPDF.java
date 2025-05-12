package com.mycompany.sipre.vista.reportes;

import javax.swing.*;
import java.awt.*;

public class PanelReporteExcelYPDF extends javax.swing.JPanel{
    private JButton btnReporteExcel;
    private JButton btnReportePDF;
    private JLabel jLabelTitulo;

    public PanelReporteExcelYPDF() {
        initComponents();
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        setBackground(new Color(204, 204, 204));
        setLayout(new GridBagLayout());

        jLabelTitulo = new JLabel();
        jLabelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jLabelTitulo.setText("GENERAR REPORTES ESTADÍSTICOS");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(20, 20, 20, 20);
        add(jLabelTitulo, gridBagConstraints);

        btnReporteExcel = new JButton();
        btnReporteExcel.setBackground(new Color(51, 153, 0));
        btnReporteExcel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReporteExcel.setForeground(Color.WHITE);
        btnReporteExcel.setText("Excel de existencias de documentos y su estatus");
        btnReporteExcel.addActionListener(evt -> btnReporteExcelActionPerformed(evt));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 20, 20, 10);
        add(btnReporteExcel, gridBagConstraints);

        btnReportePDF = new JButton();
        btnReportePDF.setBackground(new Color(204, 0, 0));
        btnReportePDF.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReportePDF.setForeground(Color.WHITE);
        btnReportePDF.setText("PDF de gráficos de por tipo de documento y estatus");
        btnReportePDF.addActionListener(evt -> btnReportePDFActionPerformed(evt));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 20, 20);
        add(btnReportePDF, gridBagConstraints);
    }

    private void btnReporteExcelActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // URL del endpoint que ya funciona
            String url = "http://localhost:8080/descargarexcel";

            // Conexión HTTP GET
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) new java.net.URL(url).openConnection();
            conn.setRequestMethod("GET");

            // Verifica que la respuesta fue exitosa
            int responseCode = conn.getResponseCode();
            if (responseCode == java.net.HttpURLConnection.HTTP_OK) {
                // Lee el contenido del archivo Excel
                java.io.InputStream inputStream = conn.getInputStream();

                // Guarda el archivo Excel en una ubicación temporal
                java.nio.file.Path outputPath = java.nio.file.Files.createTempFile("ReporteGenerado", ".xlsx");
                java.nio.file.Files.copy(inputStream, outputPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                inputStream.close();

                // Abre automáticamente el archivo Excel si el sistema lo permite
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(outputPath.toFile());
                }

                JOptionPane.showMessageDialog(this, "Reporte Excel generado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al generar el reporte Excel. Código: " + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte Excel:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void btnReportePDFActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // URL del endpoint que ya funciona
            String url = "http://localhost:8080/ReportePDF";

            // Conexión HTTP GET
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) new java.net.URL(url).openConnection();
            conn.setRequestMethod("GET");

            // Verifica que la respuesta fue exitosa
            int responseCode = conn.getResponseCode();
            if (responseCode == java.net.HttpURLConnection.HTTP_OK) {
                // Lee el contenido del PDF
                java.io.InputStream inputStream = conn.getInputStream();

                // Guarda el archivo PDF en una ubicación temporal
                java.nio.file.Path outputPath = java.nio.file.Files.createTempFile("ReporteGenerado", ".pdf");
                java.nio.file.Files.copy(inputStream, outputPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                inputStream.close();

                // Abre automáticamente el archivo PDF si el sistema lo permite
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(outputPath.toFile());
                }

                JOptionPane.showMessageDialog(this, "Reporte PDF generado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al generar el reporte PDF. Código: " + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte PDF:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
