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
public class PanelCambioContrasena extends javax.swing.JPanel {

    /**
     * Creates new form PanelCambioContrasena
     */
    public PanelCambioContrasena() {
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
        jLabel3 = new javax.swing.JLabel();
        fieldContrasena = new javax.swing.JPasswordField();
        fieldContrasena1 = new javax.swing.JPasswordField();
        fieldContrasena2 = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(217, 216, 255));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Contraseña actual: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(93, 74, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Nueva contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 77, 0, 0);
        add(jLabel2, gridBagConstraints);

        jLabel3.setText("Repetir nueva contraseña:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 32, 0, 0);
        add(jLabel3, gridBagConstraints);

        fieldContrasena.setEchoChar('*');
        fieldContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldContrasenaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 6, 0, 0);
        add(fieldContrasena, gridBagConstraints);

        fieldContrasena1.setEchoChar('*');
        fieldContrasena1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldContrasena1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        add(fieldContrasena1, gridBagConstraints);

        fieldContrasena2.setEchoChar('*');
        fieldContrasena2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldContrasena2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        add(fieldContrasena2, gridBagConstraints);

        jToggleButton1.setBackground(new java.awt.Color(148, 143, 255));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("?");
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setMargin(new java.awt.Insets(2, 2, 3, 2));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 6, 0, 70);
        add(jToggleButton1, gridBagConstraints);

        jToggleButton2.setBackground(new java.awt.Color(148, 143, 255));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("?");
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setMargin(new java.awt.Insets(2, 2, 3, 2));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 70);
        add(jToggleButton2, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 70);
        add(jToggleButton3, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(148, 143, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cambiar contraseña");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 94, 70);
        add(jButton1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldContrasenaActionPerformed

    private void fieldContrasena1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldContrasena1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldContrasena1ActionPerformed

    private void fieldContrasena2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldContrasena2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldContrasena2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // mostrar contraseña
        if (jToggleButton1.isSelected()) {
            fieldContrasena.setEchoChar((char)0);
        } else {
            fieldContrasena.setEchoChar('*');
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // mostrar contraseña
        if (jToggleButton2.isSelected()) {
            fieldContrasena1.setEchoChar((char)0);
        } else {
            fieldContrasena1.setEchoChar('*');
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // mostrar contraseña
        if (jToggleButton3.isSelected()) {
            fieldContrasena2.setEchoChar((char)0);
        } else {
            fieldContrasena2.setEchoChar('*');
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // crear dialogo para confirmar cambio de contraseña
        int opcion = JOptionPane.showOptionDialog(
            this, 
            "¿Realmente quieres cambiar la contraseña?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE, 
            null, 
            new Object[]{"No, regresar", "Aceptar"}, 
            "No, regresar"
        );

        if (opcion == 1) {
            //cambiar contraseña
            String nuevaContrasena = new String(fieldContrasena1.getPassword());
            if (true) { // TODO: verificar si la contraseña se cambió correctamente
                JOptionPane.showMessageDialog(this, "La contraseña ha sido actualizada con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "Error: La contraseña no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField fieldContrasena;
    private javax.swing.JPasswordField fieldContrasena1;
    private javax.swing.JPasswordField fieldContrasena2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables
}
