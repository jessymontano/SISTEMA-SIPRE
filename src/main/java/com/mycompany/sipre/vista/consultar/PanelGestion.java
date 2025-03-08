/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.sipre.vista.consultar;

import com.mycompany.sipre.controlador.SolicitudDAO;
import com.mycompany.sipre.modelo.Solicitud;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jessica
 */
public class PanelGestion extends javax.swing.JPanel {
    
    /**
     * Creates new form PanelGestion
     */
    public PanelGestion(JFrame frame) {
        initComponents();
    }
    
    //llenar tabla automaticamente con todas las solicitudes encontradas
    private void llenarTabla() {
        // TODO: obtener lista de documentos
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        // TODO: llenar tabla con documentos
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jDialog1.setMaximumSize(new java.awt.Dimension(500, 500));
        jDialog1.setMinimumSize(new java.awt.Dimension(500, 300));
        jDialog1.setModal(true);
        jDialog1.setPreferredSize(new java.awt.Dimension(500, 300));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Modificar Documento");

        jLabel8.setText("Tipo de documento:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cert. Uso Común", "Cert. Parcelario Individual", "Cert. Parcelario de Grupo", "Cert. Parcelario Destino Esp.", "Tit. De Solar Individual", "Tit. Dominio Pleno Individual", "Tit. Dominio Pleno de Grupo", "Tit. De Solar a Favor del Ejido", "Tit. De Solar Servicio Público", "Tit. De Solar Asoc. Religiosas" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(148, 143, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel3.setText("Folio:");

        jLabel9.setText("Cantidad disponible:");

        fieldFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFolioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldFolio))
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldCantidad)))))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnGuardar)))
                .addGap(75, 75, 75))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnGuardar)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(217, 216, 255));
        setPreferredSize(new java.awt.Dimension(587, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Gestionar formatos preimpresos");

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
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(148, 143, 255));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(148, 143, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por folio:");

        FieldFolio.setMaximumSize(new java.awt.Dimension(100, 22));
        FieldFolio.setMinimumSize(new java.awt.Dimension(100, 22));
        FieldFolio.setPreferredSize(new java.awt.Dimension(100, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(FieldFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton2)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(FieldFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
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
                setBackground(new java.awt.Color(148,143,255));
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
            // TODO: eliminar el documento
            llenarTabla(); 
        }
    }

    // abre un nuevo jDialog con un formulario para editar la información del documento
    private void abrirFormulario(int rowIndex) {
        
        btnGuardar.addActionListener(e -> {
            // TODO: actualizar documento con nueva información
            
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
