package com.mycompany.sipre.vista.gestion;

import com.mycompany.sipre.controlador.TipoController;
import com.mycompany.sipre.modelo.TipoFormatoPreimpreso;

import javax.swing.*;

public class PanelAgregarTiposFP extends javax.swing.JPanel {

    private javax.swing.JButton btnContinuar;
    private javax.swing.JTextField fieldNombreTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNombre;

    public PanelAgregarTiposFP() {
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new java.awt.GridBagLayout());

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setText("Añadir nuevo tipo de formato preimpreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 20);
        add(jLabel1, gridBagConstraints);

        jLabelNombre = new javax.swing.JLabel();
        jLabelNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 5);
        add(jLabelNombre, gridBagConstraints);

        fieldNombreTipo = new javax.swing.JTextField();
        fieldNombreTipo.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 20);
        add(fieldNombreTipo, gridBagConstraints);

        btnContinuar = new javax.swing.JButton();
        btnContinuar.setBackground(new java.awt.Color(99, 132, 182));
        btnContinuar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 20, 20);
        add(btnContinuar, gridBagConstraints);
    }

    private final TipoController tipoController = new TipoController();

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {
        String nombreTipo = fieldNombreTipo.getText().trim();
        if (!nombreTipo.isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "¿Estás seguro que quieres añadir un nuevo tipo de formato preimpreso?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                TipoFormatoPreimpreso nuevoTipo = new TipoFormatoPreimpreso();
                nuevoTipo.setNombre(nombreTipo);

                tipoController.agregarTipo(nuevoTipo, success -> {
                    if (success) {
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(this, "Tipo de formato preimpreso añadido correctamente.");
                            fieldNombreTipo.setText(""); // limpiar el campo
                        });
                    } else {
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(this, "Error al añadir el tipo de formato preimpreso.", "Error", JOptionPane.ERROR_MESSAGE);
                        });
                    }
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
