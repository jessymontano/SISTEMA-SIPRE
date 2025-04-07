/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.sipre.vista.consultar;

import com.mycompany.sipre.controlador.DocumentoController;
import com.mycompany.sipre.modelo.Documento;
import com.mycompany.sipre.modelo.Solicitud;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jessica
 */
public class PanelGestion extends javax.swing.JPanel {

    List<Documento> documentos;

    /**
     * Creates new form PanelGestion
     */
    public PanelGestion(JFrame frame) {
        initComponents();
        llenarTabla();
    }

    //llenar tabla automaticamente con todas las solicitudes encontradas
    private void llenarTabla() {
        // obtener lista de documentos
        DocumentoController documentoDAO = new DocumentoController();

        documentoDAO.obtenerTodosLosDocumentos(documentos -> {
            this.documentos = documentos;
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Documento documento : documentos) {
                model.addRow(new Object[]{
                    documento.getFolio(),
                    documento.getTipoDocumento(),
                    documento.getCantidadDocumentos(),
                    "Modificar",
                    "Eliminar"
                });
            }
        });

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

        jDialog1 = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fieldFolio = new javax.swing.JTextField();
        fieldCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        FieldFolio = new javax.swing.JTextField();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setTitle("Modificar solicitud");
        jDialog1.setAlwaysOnTop(true);
        jDialog1.setMinimumSize(new java.awt.Dimension(500, 300));
        jDialog1.setModal(true);
        jDialog1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Modificar Documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 47, 0, 0);
        jDialog1.getContentPane().add(jLabel4, gridBagConstraints);

        jLabel8.setText("Tipo de documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 72, 0, 0);
        jDialog1.getContentPane().add(jLabel8, gridBagConstraints);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cert. Uso Común", "Cert. Parcelario Individual", "Cert. Parcelario de Grupo", "Cert. Parcelario Destino Esp.", "Tit. De Solar Individual", "Tit. Dominio Pleno Individual", "Tit. Dominio Pleno de Grupo", "Tit. De Solar a Favor del Ejido", "Tit. De Solar Servicio Público", "Tit. De Solar Asoc. Religiosas" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -57;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 169);
        jDialog1.getContentPane().add(comboTipo, gridBagConstraints);

        btnGuardar.setBackground(new java.awt.Color(148, 143, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 50, 65, 0);
        jDialog1.getContentPane().add(btnGuardar, gridBagConstraints);

        jLabel3.setText("Folio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 72, 0, 0);
        jDialog1.getContentPane().add(jLabel3, gridBagConstraints);

        jLabel9.setText("Cantidad disponible:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 72, 0, 0);
        jDialog1.getContentPane().add(jLabel9, gridBagConstraints);

        fieldFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFolioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 6, 0, 169);
        jDialog1.getContentPane().add(fieldFolio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 169);
        jDialog1.getContentPane().add(fieldCantidad, gridBagConstraints);

        setBackground(new java.awt.Color(217, 216, 255));
        setPreferredSize(new java.awt.Dimension(587, 300));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Gestionar formatos preimpresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 212, 0, 0);
        add(jLabel1, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Tipo de documento", "Cantidad disponible", "Modificar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer("Modificar"));
        jTable1.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), "Modificar"));

        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer("Eliminar"));
        jTable1.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox(), "Eliminar"));
        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBackground(new Color(77,77,77));
                setForeground(Color.WHITE);
                setFont(new Font("Segoe UI", Font.BOLD, 12));
                return this;
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 601;
        gridBagConstraints.ipady = 229;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        add(jScrollPane1, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(148, 143, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        add(jButton2, gridBagConstraints);

        jLabel2.setText("Buscar por folio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 161, 0, 0);
        add(jLabel2, gridBagConstraints);

        FieldFolio.setMaximumSize(new java.awt.Dimension(100, 22));
        FieldFolio.setMinimumSize(new java.awt.Dimension(100, 22));
        FieldFolio.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        add(FieldFolio, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // buscar por folio
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String folio = model.getValueAt(i, 0).toString();
            if (folio.equals(FieldFolio.getText())) { //si el folio es igual seleccionar el renglón
                jTable1.setRowSelectionInterval(i, i);
                jTable1.scrollRectToVisible(new Rectangle(jTable1.getCellRect(i, 0, true)));
                return;
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void fieldFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFolioActionPerformed

    // clase para mostrar botones en la tabla
    class ButtonRenderer extends JButton implements TableCellRenderer {

        private String actionType;

        public ButtonRenderer(String actionType) {
            this.actionType = actionType;
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(new java.awt.Color(148, 143, 255));
            }

            if ("Modificar".equals(actionType)) {
                ImageIcon icono = new ImageIcon(getClass().getResource("/edit.png"));
                Image image = icono.getImage();
                Image nuevaImagen = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                icono = new ImageIcon(nuevaImagen);
                setIcon(icono);
            } else if ("Eliminar".equals(actionType)) {
                ImageIcon icono = new ImageIcon(getClass().getResource("/delete.png"));
                Image image = icono.getImage();
                Image nuevaImagen = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                icono = new ImageIcon(nuevaImagen);
                setIcon(icono);
            }

            return this;
        }
    }

    // clase para hacer que funcionen los botones dentro de la tabla y obtengan la información del documento seleccionado
    class ButtonEditor extends DefaultCellEditor {

        private JButton button;
        private boolean isPushed;
        private int selectedRow;
        private String actionType;

        public ButtonEditor(JCheckBox checkBox, String actionType) {
            super(checkBox);
            this.actionType = actionType;
            button = new JButton();
            button.setOpaque(true);

            if ("Modificar".equals(actionType)) {
                ImageIcon icono = new ImageIcon(getClass().getResource("/edit.png"));
                Image image = icono.getImage();
                Image nuevaImagen = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                icono = new ImageIcon(nuevaImagen);
                button.setIcon(icono);
            } else if ("Eliminar".equals(actionType)) {
                ImageIcon icono = new ImageIcon(getClass().getResource("/delete.png"));
                Image image = icono.getImage();
                Image nuevaImagen = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                icono = new ImageIcon(nuevaImagen);
                button.setIcon(icono);
            }

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ("Modificar".equals(actionType)) {
                        abrirFormulario(selectedRow);
                    } else if ("Eliminar".equals(actionType)) {
                        int option = JOptionPane.showConfirmDialog(null,
                                "¿Está seguro de que desea eliminar este documento?",
                                "Confirmar", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            eliminarDocumento(selectedRow);
                        }
                    }
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            selectedRow = row;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return actionType;
        }

        private void eliminarDocumento(int rowIndex) {
            DocumentoController documentoDAO = new DocumentoController();

            documentoDAO.eliminarDocumento(documentos.get(rowIndex).getFolio(), eliminado -> {
                if (eliminado) {

                }
            });

            llenarTabla();
        }
    }

    // abre un nuevo jDialog con un formulario para editar la información del documento
    private void abrirFormulario(int rowIndex) {
        Documento documento = documentos.get(rowIndex);
        int folioAnterior = documento.getFolio();

        btnGuardar.addActionListener(e -> {
            documento.setFolio(Integer.parseInt(fieldFolio.getText()));
            documento.setTipoDocumento((String) comboTipo.getSelectedItem());
            documento.setCantidadDocumentos(Integer.parseInt(fieldCantidad.getText()));

            // actualizar el documento con los datos introducidos
            DocumentoController documentoDAO = new DocumentoController();
            documentoDAO.actualizarDocumento(folioAnterior, documento, actualizado -> {

            });

            llenarTabla();
            jDialog1.dispose();
        });

        jDialog1.setLocationRelativeTo(this);
        jDialog1.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FieldFolio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JTextField fieldCantidad;
    private javax.swing.JTextField fieldFolio;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
