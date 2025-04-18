/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.sipre.vista.solicitar;

import com.mycompany.sipre.controlador.DocumentoController;
import com.mycompany.sipre.controlador.GeneradorPDF;
import com.mycompany.sipre.controlador.SolicitudController;
import com.mycompany.sipre.modelo.Documento;
import com.mycompany.sipre.modelo.Solicitud;
import java.io.IOException;

import javax.swing.*;
import java.sql.Date;

/**
 *
 * @author jessica
 */
public class PanelSolicitud extends javax.swing.JPanel {

    /**
     * Creates new form PanelSolicitud
     */
    public PanelSolicitud(JFrame frames) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FieldFolio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ComboAno = new javax.swing.JComboBox<>();
        ComboMes = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(217, 216, 255));
        setPreferredSize(new java.awt.Dimension(587, 300));
        setLayout(new java.awt.GridBagLayout());

        jButton2.setBackground(new java.awt.Color(148, 143, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Guardar solicitud");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 22, 162);
        add(jButton2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Solicitud de impresión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 17, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Folio Existente en bodega:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 135, 0, 0);
        add(jLabel2, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(148, 143, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Check");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 22, 162);
        add(jButton3, gridBagConstraints);

        jLabel3.setText("Tipo de documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 135, 0, 0);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Fecha de solicitud:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 135, 0, 0);
        add(jLabel4, gridBagConstraints);

        FieldFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldFolioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = 40;
        gridBagConstraints.ipadx = 159;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 1, 0, 0);
        add(FieldFolio, gridBagConstraints);

        jLabel6.setText("Tipo de documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(jLabel6, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Limpiar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 51, 22, 0);
        add(jButton1, gridBagConstraints);

        jLabel5.setText("Motivo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 135, 0, 0);
        add(jLabel5, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 50;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 228;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 162);
        add(jScrollPane1, gridBagConstraints);

        int anoInicio = 2000;
        int anoActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        String[] anos = new String[anoActual - anoInicio + 1];

        for (int i = 0; i <= anoActual - anoInicio; i++) {
            anos[i] = String.valueOf(anoActual - i);
        }
        ComboAno.setModel(new javax.swing.DefaultComboBoxModel<>(anos));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 0, 0);
        add(ComboAno, gridBagConstraints);

        ComboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        ComboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 26;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 162);
        add(ComboMes, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Verificar si el campo de folio no está vacío
            String folioText = FieldFolio.getText().trim();
            if (folioText.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "El campo Folio no puede estar vacío.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convierte el texto del folio a entero
            int folio = Integer.parseInt(folioText);

            // Llamar al método para obtener el tipo de documento
            DocumentoController documentoController = new DocumentoController();
            SolicitudController solicitudController = new SolicitudController();
            documentoController.obtenerDocumentoPorFolio(folio, documento -> {
                String tipoDocumento = documento.getTipoDocumento();

                if (tipoDocumento != null) {
                    jLabel6.setText(tipoDocumento);  // Establecer el valor del tipo de documento
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Folio no encontrado.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return; // Salir si no se encuentra el folio
                }

                // Validar el motivo
                String motivo = jTextArea1.getText().trim();
                if (motivo.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "El campo Motivo no puede estar vacío.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener la fecha seleccionada
                String anoSeleccionado = ComboAno.getSelectedItem().toString();
                int mesSeleccionado = ComboMes.getSelectedIndex() + 1;

                if (mesSeleccionado == 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione un mes válido.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Formato de fecha: "YYYY-MM-DD"
                String fechaStr = String.format("%s-%02d-01", anoSeleccionado, mesSeleccionado);
                Date fechaSolicitud = Date.valueOf(fechaStr);

                // Continuar con la lógica de agregar la solicitud solo si todo está bien
                solicitudController.agregarSolicitud(new Solicitud(folio, tipoDocumento, fechaSolicitud, motivo), resultado -> {
                    if (resultado) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Solicitud guardada con éxito!");

                        // Generar el PDF después de guardar la solicitud
                        GeneradorPDF.generarPDF(folio, tipoDocumento, fechaSolicitud, motivo);  // Llamada al método para generar el PDF

                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar la solicitud.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                });

            });

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un folio válido.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la fecha seleccionada.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Captura cualquier otra excepción que pueda ocurrir
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Obtén el número de folio desde el campo de texto
            int folio = Integer.parseInt(FieldFolio.getText()); // Convierte el texto del folio a entero

            // Crear el objeto de acceso a datos (SolicitudDAO)
            DocumentoController documentoController = new DocumentoController();
            SolicitudController solicitudController = new SolicitudController();
            documentoController.obtenerDocumentoPorFolio(folio, documento -> {
                String tipoDocumento = documento.getTipoDocumento();

                // Si el tipo de documento es encontrado, actualizar la etiqueta
                if (tipoDocumento != null) {
                    jLabel6.setText(tipoDocumento);  // Actualiza el texto de la etiqueta con el tipo de documento
                } else {
                    // Si no se encuentra el folio, mostrar mensaje de error
                    javax.swing.JOptionPane.showMessageDialog(this, "Folio no encontrado.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            });

        } catch (NumberFormatException e) {
            // Si no se pudo convertir el folio a número, mostrar mensaje de error
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un folio válido.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }


    private void FieldFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldFolioActionPerformed

    private void ComboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAno;
    private javax.swing.JComboBox<String> ComboMes;
    private javax.swing.JTextField FieldFolio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
