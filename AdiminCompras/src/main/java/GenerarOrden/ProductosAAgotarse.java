/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GenerarOrden;

import GenerarOrden.GenerarOrden;
import Negocio.dto.ProductoCompradoDto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import subSistemaProductosComprados.FachadaProductosComprados;
import subSistemaProductosComprados.IConsultarProductoCompradoBO;
import subSistemaAgregarProducto.IagregarProductoBO;
import subSistemaAgregarProducto.IinventarioBajoBO;
import subSistemaAgregarProducto.fachadaInventarioBajo;
import subSistemaAgregarProducto.fachadaAgregarProductos;
import subsistema.ILlenarTabla;
import subsistema.FachadaLLenarTabla;

/**
 *
 * @author tacot
 */
public class ProductosAAgotarse extends javax.swing.JFrame {

    GenerarOrden FrameOrden;

    List<ProductoCompradoDto> productosAgotados = new ArrayList<>();

    IinventarioBajoBO inventario = new fachadaInventarioBajo();

    ILlenarTabla llenarT = new FachadaLLenarTabla();

    IagregarProductoBO agregar = new fachadaAgregarProductos();

    List<ProductoCompradoDto> productosComprados = new ArrayList<>();

    IConsultarProductoCompradoBO PC = new FachadaProductosComprados();

    /**
     * Creates new form ProductosAAgotarse
     */
    public ProductosAAgotarse() {
        initComponents();

        productosComprados = PC.getListaProductosComprados();

        productosAgotados = inventario.obtenerProductosPorAgotarse();

        llenarT.llenarTabla(productosAgotados, tablaProductos);

    }

    public javax.swing.JPanel traerContenido() {
        return this.contenido;
    }

    public void posicion(GenerarOrden orden) {
        this.FrameOrden = orden;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productoA = new javax.swing.JPanel();
        contenido = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(528, 351));

        productoA.setBackground(new java.awt.Color(24, 50, 77));
        productoA.setPreferredSize(new java.awt.Dimension(528, 351));

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setPreferredSize(new java.awt.Dimension(528, 351));

        Agregar.setBackground(new java.awt.Color(24, 50, 77));
        Agregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Agregar.setForeground(new java.awt.Color(255, 255, 255));
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        tablaProductos.setBackground(new java.awt.Color(214, 217, 223));
        tablaProductos.setForeground(new java.awt.Color(0, 0, 0));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Proveedor", "P/U", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
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
        tablaProductos.setGridColor(new java.awt.Color(0, 0, 204));
        jScrollPane1.setViewportView(tablaProductos);

        jPanel1.setBackground(new java.awt.Color(24, 50, 77));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos a punto de agotarse");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(121, 121, 121))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\tacot\\Documents\\GitHub\\AdminCompras\\DisenoSoftware\\AdiminCompras\\src\\main\\resources\\regresar.png")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(Agregar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout productoALayout = new javax.swing.GroupLayout(productoA);
        productoA.setLayout(productoALayout);
        productoALayout.setHorizontalGroup(
            productoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        productoALayout.setVerticalGroup(
            productoALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productoA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productoA, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if (tablaProductos.getSelectedRow() != -1) {
            ProductoCompradoDto pr = new ProductoCompradoDto();
            pr.setNombre((String) tablaProductos.getModel().getValueAt(tablaProductos.getSelectedRow(), 0));

            pr.setProveedor((String) tablaProductos.getModel().getValueAt(tablaProductos.getSelectedRow(), 2));
            
//            String cantidad = (String) tablaProductos.getModel().getValueAt(tablaProductos.getSelectedRow(), 4);

            agregar.agregarCompraLista(pr);

            FrameOrden.Contenido.removeAll();

            ValidarInfo va  = new ValidarInfo();

            FrameOrden.Contenido.add(va.traerContenido());

            FrameOrden.Contenido.revalidate();
            FrameOrden.Contenido.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        }


    }//GEN-LAST:event_AgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrameOrden.validar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JPanel contenido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel productoA;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
