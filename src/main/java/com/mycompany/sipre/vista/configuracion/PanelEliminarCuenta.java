/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.sipre.vista.configuracion;

import javax.swing.JOptionPane;

/**
 *
 * @author jessica
 */
public class PanelEliminarCuenta extends javax.swing.JPanel {

    /**
     * Creates new form PanelEliminarCuenta
     */
    public PanelEliminarCuenta() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonContinuar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaMotivo = new javax.swing.JTextArea();
        fieldContrasena = new javax.swing.JPasswordField();
        jToggleButton3 = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(217, 216, 255));
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Eliminar cuenta");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 32, -1, -1));

        jLabel2.setText("Motivo:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 81, -1, -1));

        jLabel3.setText("Ingrese su contraseña:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 190, -1, -1));

        botonContinuar.setBackground(new java.awt.Color(148, 143, 255));
        botonContinuar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonContinuar.setForeground(new java.awt.Color(255, 255, 255));
        botonContinuar.setText("Continuar");
        botonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContinuarActionPerformed(evt);
            }
        });
        add(botonContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 223, -1, -1));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(100, 50));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 50));

        textAreaMotivo.setColumns(20);
        textAreaMotivo.setRows(5);
        textAreaMotivo.setMaximumSize(new java.awt.Dimension(100, 50));
        textAreaMotivo.setPreferredSize(new java.awt.Dimension(100, 50));
        jScrollPane1.setViewportView(textAreaMotivo);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 81, 210, 86));

        fieldContrasena.setEchoChar('*');
        add(fieldContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 176, -1));

        jToggleButton3.setBackground(new java.awt.Color(148, 143, 255));
        jToggleButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setText("?");
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setMargin(new java.awt.Insets(2, 2, 3, 2));
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 26, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void botonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContinuarActionPerformed
        // crear dialogo para confirmar cambio de contraseña
        int opcion = JOptionPane.showOptionDialog(
            this,
            "¿Está seguro que desea eliminar su cuenta?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,
            new Object[]{"No, regresar", "Sí, continuar"},
            "No, regresar"
        );

        if (opcion == 1) {
            //eliminar cuenta
        }
    }//GEN-LAST:event_botonContinuarActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // mostrar contraseña
        if (jToggleButton3.isSelected()) {
            fieldContrasena.setEchoChar((char)0);
        } else {
            fieldContrasena.setEchoChar('*');
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonContinuar;
    private javax.swing.JPasswordField fieldContrasena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTextArea textAreaMotivo;
    // End of variables declaration//GEN-END:variables
}
