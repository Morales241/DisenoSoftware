/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package entradaInventario;

import Negocio.dto.OrdenCompraDto;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import subSistemaEntradaInventario.IFachadaEntradaInventario;
import subSistemaEntradaInventario.fachadaEntradaInventario;

/**
 *
 * @author tacot
 */
public class EntradaInventario extends javax.swing.JFrame implements Border {

    int radius = 500;
    IFachadaEntradaInventario fachada = new fachadaEntradaInventario();
    protected String folio = "";

    /**
     * Creates new form EntradaInventario
     */
    public EntradaInventario() {
        initComponents();

        try{
        fachada.llenarTablaOrdenes(tablaEntradas);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public javax.swing.JPanel traerContenido() {
        return this.contenido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenido = new javax.swing.JPanel();
        panelEntradas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntradas = new javax.swing.JTable();
        verOrdenes = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        botonReportar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        desde = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        hasta = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenido.setBackground(new java.awt.Color(255, 255, 255));

        panelEntradas.setBackground(new java.awt.Color(24, 50, 77));

        tablaEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Folio", "Fecha Entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEntradas.setBackground(new java.awt.Color(214, 217, 223));
        tablaEntradas.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(tablaEntradas);

        javax.swing.GroupLayout panelEntradasLayout = new javax.swing.GroupLayout(panelEntradas);
        panelEntradas.setLayout(panelEntradasLayout);
        panelEntradasLayout.setHorizontalGroup(
            panelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEntradasLayout.setVerticalGroup(
            panelEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        verOrdenes.setText("Ver órdenes");
        verOrdenes.setBackground(new java.awt.Color(24, 50, 77));
        verOrdenes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        verOrdenes.setForeground(new java.awt.Color(255, 255, 255));
        verOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verOrdenesActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.setBackground(new java.awt.Color(24, 50, 77));
        aceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aceptar.setForeground(new java.awt.Color(255, 255, 255));
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        botonReportar.setText("Reportar");
        botonReportar.setBackground(new java.awt.Color(255, 0, 0));
        botonReportar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonReportar.setForeground(new java.awt.Color(255, 255, 255));
        botonReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReportarActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecciona la fecha de inicio");

        jLabel4.setText("Selecciona la fecha de fin");

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)))
                        .addGap(34, 34, 34)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                        .addComponent(panelEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonReportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(271, 271, 271))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                        .addComponent(verOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(verOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonReportar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void verOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verOrdenesActionPerformed
        // TODO add your handling code here:

        if (this.desde.getDate() != null || this.hasta.getDate() != null) {

            Date fecha1 = Date.from(this.desde.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date fecha2 = Date.from(this.hasta.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());

            fachada.llenarTablaFiltrada(tablaEntradas, fecha1, fecha2);
            
          
        }else{
            JOptionPane.showConfirmDialog(null, "Periodo no seleccionado");
            fachada.llenarTablaOrdenes(tablaEntradas);
            
        }
        
        this.botonReportar.setVisible(true);
            

    }//GEN-LAST:event_verOrdenesActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        
        int filaSeleccionada = this.tablaEntradas.getSelectedRow();
                
        if (filaSeleccionada >= 0) {
            this.folio = (String) this.tablaEntradas.getValueAt(filaSeleccionada, 0);
            
            OrdenCompraDto orden = fachada.ordenPorFolio(folio);
            
            this.botonReportar.setVisible(false);
            
        }else {
            JOptionPane.showConfirmDialog(null, "Ninguna fila seleccionada");
        }

    }//GEN-LAST:event_aceptarActionPerformed

    private void botonReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReportarActionPerformed
        // TODO add your handling code here:

        int filaSeleccionada = this.tablaEntradas.getSelectedRow();
                
        if (filaSeleccionada >= 0) {
            
            JOptionPane.showConfirmDialog(null, "La orden con el folio: " + folio + "ha sido reportada exitosamente");
            
        }else {
            JOptionPane.showConfirmDialog(null, "Ninguna fila seleccionada");
        }
   
    }//GEN-LAST:event_botonReportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton botonReportar;
    private javax.swing.JPanel contenido;
    private com.github.lgooddatepicker.components.DatePicker desde;
    private com.github.lgooddatepicker.components.DatePicker hasta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelEntradas;
    private javax.swing.JTable tablaEntradas;
    private javax.swing.JButton verOrdenes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
