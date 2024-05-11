/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pago;

import ConsultaOrden.FachadaPagar;
import ConsultaOrden.Ipagar;
import GenerarOrden.GenerarOrden;
import Negocio.dto.OrdenCompraDto;
import Negocio.dto.ProductoCompradoDto;
import informacion.Informacion;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import presentacion.Inicio;
import subsistema.FachadaLLenarTabla;
import subsistema.ILlenarTabla;

/**
 *
 * @author
 */
public class Pago extends javax.swing.JFrame {

    Inicio inicio;
    ILlenarTabla llenarT = new FachadaLLenarTabla();
    List<OrdenCompraDto> ordenes = null;
    OrdenCompraDto orden = null;
    Ipagar pago = new FachadaPagar();

    /**
     * Creates new form Pago
     */
    public Pago() {
        initComponents();
        this.ordenes = new ArrayList<>();
        this.ordenes = pago.consultarOrdenes();

        for (OrdenCompraDto o : ordenes) {
            if (o.isEstado() == false) {
                ResultadosOrdenes.addItem(o);
            }
        }
        if (ResultadosOrdenes.getItemCount() > 0) {
            
            ResultadosOrdenes.setSelectedIndex(0);

            orden = (OrdenCompraDto) ResultadosOrdenes.getSelectedItem();

            llenarTabla(orden);

            sacarTotal(orden);
        }

        this.ResultadosOrdenes.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    orden = (OrdenCompraDto) ResultadosOrdenes.getSelectedItem();

                    llenarTabla(orden);

                    sacarTotal(orden);
                }
            }
        });

    }

    public javax.swing.JPanel traerContenido() {
        return this.contenido;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenido = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ResultadosOrdenes = new javax.swing.JComboBox<>();
        consulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        Total = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        botonPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setPreferredSize(new java.awt.Dimension(675, 500));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Seleccione Orden:");

        ResultadosOrdenes.setBackground(new java.awt.Color(24, 50, 77));
        ResultadosOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultadosOrdenesMouseClicked(evt);
            }
        });
        ResultadosOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultadosOrdenesActionPerformed(evt);
            }
        });

        consulta.setBackground(new java.awt.Color(255, 255, 255));

        tablaProductos.setBackground(new java.awt.Color(214, 217, 223));
        tablaProductos.setForeground(new java.awt.Color(0, 0, 0));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto", "Proveedor", "P/U", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setGridColor(new java.awt.Color(0, 0, 204));
        jScrollPane1.setViewportView(tablaProductos);

        Total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));
        Total.setText("   ");

        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(0, 0, 0));
        total.setText("Total:");

        botonPagar.setBackground(new java.awt.Color(24, 50, 77));
        botonPagar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        botonPagar.setForeground(new java.awt.Color(255, 255, 255));
        botonPagar.setText("Pagar");
        botonPagar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonPagar.setBorderPainted(false);
        botonPagar.setFocusPainted(false);
        botonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout consultaLayout = new javax.swing.GroupLayout(consulta);
        consulta.setLayout(consultaLayout);
        consultaLayout.setHorizontalGroup(
            consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultaLayout.createSequentialGroup()
                .addGroup(consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultaLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(botonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(total)
                        .addGap(18, 18, 18)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(consultaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        consultaLayout.setVerticalGroup(
            consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultaLayout.createSequentialGroup()
                        .addGroup(consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaLayout.createSequentialGroup()
                        .addGap(0, 47, Short.MAX_VALUE)
                        .addComponent(botonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(ResultadosOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ResultadosOrdenes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ResultadosOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultadosOrdenesMouseClicked

    }//GEN-LAST:event_ResultadosOrdenesMouseClicked

    private void ResultadosOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultadosOrdenesActionPerformed

    }//GEN-LAST:event_ResultadosOrdenesActionPerformed

    private void botonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPagarActionPerformed
        try {
            pago.pagarOrden(orden);

            JOptionPane.showMessageDialog(null, "El pago se realizo de manera efectiva");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (inicio == null) {
            contenido.removeAll();

            Pago pago2 = new Pago();

            contenido.add(pago2.traerContenido());

            contenido.revalidate();
            contenido.repaint();
        } else {

            Informacion info = new Informacion();
            inicio.Contenido.removeAll();
            inicio.Contenido.add(info.traerContenido());
            inicio.Contenido.revalidate();
            inicio.Contenido.repaint();
        }

    }//GEN-LAST:event_botonPagarActionPerformed

    public void llenarTabla(OrdenCompraDto orden) {

        if (ordenes.isEmpty()) {
            this.botonPagar.setVisible(false);
        } else {
            this.botonPagar.setVisible(true);
        }

        tablaProductos.removeAll();

        llenarT.llenarTabla(orden.getProductos(), tablaProductos);
    }

    public void sacarTotal(OrdenCompraDto orden) {
        double totalP = 0;

        for (ProductoCompradoDto p : orden.getProductos()) {
            totalP += (p.getCantidad() * p.getPrecio());
        }

        this.Total.setText(String.valueOf(totalP));
    }

    public void posicion(Inicio ini) {
        this.inicio = ini;
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Pago().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<OrdenCompraDto> ResultadosOrdenes;
    private javax.swing.JLabel Total;
    private javax.swing.JButton botonPagar;
    private javax.swing.JPanel consulta;
    private javax.swing.JPanel contenido;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
