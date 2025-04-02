/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.sipre.vista.buscar;

import com.mycompany.sipre.controlador.DocumentoController;
import com.mycompany.sipre.modelo.Documento;
import com.mycompany.sipre.modelo.Solicitud;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jessica
 */
public class PanelFolio extends javax.swing.JPanel {

    /**
     * Creates new form PanelFolio
     */
    public PanelFolio(JFrame frame) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FieldFolio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(217, 216, 255));
        setPreferredSize(new java.awt.Dimension(587, 300));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por folio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 245, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Ingrese el número de folio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 221, 0, 0);
        add(jLabel2, gridBagConstraints);

        FieldFolio.setMaximumSize(new java.awt.Dimension(100, 22));
        FieldFolio.setMinimumSize(new java.awt.Dimension(100, 22));
        FieldFolio.setPreferredSize(new java.awt.Dimension(100, 22));
        FieldFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldFolioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 221, 0, 0);
        add(FieldFolio, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(148, 143, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 256, 0, 0);
        add(jButton1, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Folio", "Tipo de documento", "Estatus", "Cantidad de documentos", "Fecha de emisión", "Motivo"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(300, 100));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(148, 143, 255));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 436;
        gridBagConstraints.ipady = 230;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 72, 6, 63);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void FieldFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldFolioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // Obtener el folio desde el campo de texto (FieldFolio es el JTextField)
            int folio = Integer.parseInt(FieldFolio.getText().trim());

            // Crear instancia del DAO y buscar el documento
            DocumentoController documentoController = new DocumentoController();
            
            Documento documento = documentoController.obtenerDocumentoPorFolio(folio);

            if (documento != null) {
                // Limpiar la tabla antes de mostrar los nuevos resultados
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                // Agregar los datos del documento a la tabla
                model.addRow(new Object[]{
                        documento.getFolio(),
                        documento.getTipoDocumento(),
                        documento.getEstatus(),
                        documento.getCantidadDocumentos(),
                        documento.getFecha(),
                        documento.getMotivo()
                });
            } else {
                // Mostrar mensaje si no se encuentra el documento
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontró ningún documento con el folio ingresado.", "Información", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException | IOException e) {
            // Manejar el caso donde el folio no sea un número válido
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un folio válido (número entero).", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FieldFolio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
