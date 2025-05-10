package com.mycompany.sipre.vista.solicitar;

import com.mycompany.sipre.controlador.GeneradorPDF;
import com.mycompany.sipre.controlador.SolicitudController;
import com.mycompany.sipre.modelo.Solicitud;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.DefaultCellEditor;

public class PanelConsultarSolicitud extends javax.swing.JPanel {

    private List<Solicitud> solicitudes;

    public PanelConsultarSolicitud(JFrame frame) {
        initComponents();
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                llenarTabla();
            }
        });
    }

    private void llenarTabla() {
        SolicitudController solicitudController = new SolicitudController();
        
        solicitudController.obtenerTodasLasSolicitudes(solicitudes -> {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            if (solicitudes != null) {
                this.solicitudes = solicitudes;
                for (Solicitud solicitud : solicitudes) {
                    model.addRow(new Object[]{
                        solicitud.getFolio(),
                        solicitud.getTipoDocumento(),
                        solicitud.getFecha(),
                        "Ver PDF"
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No se pudieron cargar las solicitudes", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Clase para renderizar el botón en la tabla
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(new Color(99, 132, 182));
                setForeground(Color.WHITE);
            }
            setText("Ver PDF");
            return this;
        }
    }

    // Clase para manejar el clic en el botón
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    abrirPDF(selectedRow);
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            selectedRow = row;
            button.setText("Ver PDF");
            button.setBackground(new Color(99, 132, 182));
            button.setForeground(Color.WHITE);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Ver PDF";
        }
    }

    private void abrirPDF(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < solicitudes.size()) {
            Solicitud solicitud = solicitudes.get(rowIndex);
            
            // Generar y mostrar el PDF en el navegador
            GeneradorPDF.mostrarPDFEnNavegador(
                solicitud.getFolio(),
                solicitud.getTipoDocumento(),
                solicitud.getFecha(),
                solicitud.getMotivo()
            );
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Listado de Solicitudes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Folio", "Tipo de documento", "Fecha de solicitud", "PDF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        // Configurar el renderizador y editor para la columna de PDF
        jTable1.getColumn("PDF").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("PDF").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        // Personalizar encabezado de tabla
        jTable1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBackground(new Color(70, 70, 70));
                setForeground(Color.WHITE);
                setFont(new Font("Segoe UI", Font.BOLD, 12));
                return this;
            }
        });
        
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(new Color(220, 220, 220));
        jTable1.setSelectionBackground(new Color(158, 188, 226));
        
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}