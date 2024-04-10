/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GenerarOrden;

import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.objetosNegocio.IOrdenNegocio;
import Negocio.objetosNegocio.OrdenNegocio;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import subSistemaAgregarProducto.IagregarProductoBO;
import subSistemaAgregarProducto.agregarProductoBO;
import subSistemaConsultarProducto.IConsultarProducto;
import subSistemaConsultarProducto.consultarProductos;
import subSistemaConsultarProveedores.IConsultarProveedores;
import subSistemaConsultarProveedores.consultarProveedoresBO;

/**
 *
 * @author tacot
 */
public class AgregarProducto extends javax.swing.JFrame {

    GenerarOrden FrameOrden;
    
    private int cantidad = 1;
    
    private String palabra = "";

    List<ProductoDto> Productos = new ArrayList<>();

    IConsultarProducto consultaP = new consultarProductos();
    
    IOrdenNegocio orden = new OrdenNegocio();
    
    IConsultarProveedores proveedoresConsulta = new consultarProveedoresBO();
    
    IagregarProductoBO agregar = new agregarProductoBO();
    
    /**
     * Creates new form AgregarProducto
     */
    public AgregarProducto()  {

        initComponents();

        this.Productos = consultaP.obtenerProductos();

        for (ProductoDto p : Productos) {
            this.ResultadosProductos.addItem(p);
        }

        for (ProductoProveedorDto p : proveedoresConsulta.obtenerProveedores(this.Productos.get(0).getId())) {
            this.ResultadosProveedores.addItem(p);
        }

        this.panelCantidad.setVisible(false);
        this.panelProducto.setVisible(false);
        this.panelProveedor.setVisible(false);

        this.txtProductoBuscado.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (palabra.length() > 0) {
                        palabra = palabra.substring(0, palabra.length() - 1);
                    }
                } else {
                    char c = e.getKeyChar();
                    palabra += c;
                }

                ResultadosProductos.removeAllItems();

                Productos = orden.obtenerCoincidenciasProductos(palabra);

                for (ProductoDto p : Productos) {
                    ResultadosProductos.addItem(p);
                }

                panelCantidad.setVisible(true);
                panelProducto.setVisible(true);
                panelProveedor.setVisible(true);
            }
        });

        this.ResultadosProductos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ResultadosProveedores.removeAllItems();
                    
                    ProductoDto productoS = (ProductoDto) ResultadosProductos.getSelectedItem();
                          
                    
                    try {
                        for (ProductoProveedorDto p : proveedoresConsulta.obtenerProveedores(productoS.getId())) {
                            ResultadosProveedores.addItem(p);            
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    public AgregarProducto(GenerarOrden Frameorden) throws Exception {

        posicion(Frameorden);
        
        initComponents();
        
        this.Productos = consultaP.obtenerProductos();

        for (ProductoDto p : Productos) {
            this.ResultadosProductos.addItem(p);
        }

        for (ProductoProveedorDto p : proveedoresConsulta.obtenerProveedores(this.Productos.get(0).getId())) {
            this.ResultadosProveedores.addItem(p);
        }

        this.panelCantidad.setVisible(false);
        this.panelProducto.setVisible(false);
        this.panelProveedor.setVisible(false);

        this.txtProductoBuscado.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (palabra.length() > 0) {
                        palabra = palabra.substring(0, palabra.length() - 1);
                    }
                } else {
                    char c = e.getKeyChar();
                    palabra += c;
                }

                ResultadosProductos.removeAllItems();

                Productos = orden.obtenerCoincidenciasProductos(palabra);

                for (ProductoDto p : Productos) {
                    ResultadosProductos.addItem(p);
                }

                panelCantidad.setVisible(true);
                panelProducto.setVisible(true);
                panelProveedor.setVisible(true);
            }
        });

        this.ResultadosProductos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ResultadosProveedores.removeAllItems();
                    
                    ProductoDto productoS = (ProductoDto) ResultadosProductos.getSelectedItem();
                    
                    try {
                        for (ProductoProveedorDto p : proveedoresConsulta.obtenerProveedores(productoS.getId())) {
                            ResultadosProveedores.addItem(p);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenido = new javax.swing.JPanel();
        botonSiguiente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtProductoBuscado = new javax.swing.JTextField();
        panelProducto = new javax.swing.JPanel();
        ResultadosProductos = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        panelProveedor = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ResultadosProveedores = new javax.swing.JComboBox<>();
        panelCantidad = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        menos = new javax.swing.JButton();
        mas = new javax.swing.JButton();
        txtCantidad = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setPreferredSize(new java.awt.Dimension(528, 351));
        contenido.setLayout(null);

        botonSiguiente.setBackground(new java.awt.Color(24, 50, 77));
        botonSiguiente.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        botonSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        botonSiguiente.setText("Agregar");
        botonSiguiente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonSiguiente.setBorderPainted(false);
        botonSiguiente.setFocusPainted(false);
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });
        contenido.add(botonSiguiente);
        botonSiguiente.setBounds(189, 270, 133, 36);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre del Producto:");
        contenido.add(jLabel5);
        jLabel5.setBounds(18, 69, 183, 25);

        txtProductoBuscado.setBackground(new java.awt.Color(24, 50, 77));
        txtProductoBuscado.setForeground(new java.awt.Color(0, 0, 0));
        contenido.add(txtProductoBuscado);
        txtProductoBuscado.setBounds(219, 72, 290, 25);

        panelProducto.setBackground(new java.awt.Color(255, 255, 255));

        ResultadosProductos.setBackground(new java.awt.Color(24, 50, 77));
        ResultadosProductos.setForeground(new java.awt.Color(0, 0, 0));
        ResultadosProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultadosProductosMouseClicked(evt);
            }
        });
        ResultadosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultadosProductosActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Seleccione Producto:");

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addComponent(ResultadosProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResultadosProductos)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        contenido.add(panelProducto);
        panelProducto.setBounds(6, 103, 518, 38);

        panelProveedor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Seleccione Proveedor:");

        ResultadosProveedores.setBackground(new java.awt.Color(24, 50, 77));
        ResultadosProveedores.setForeground(new java.awt.Color(0, 0, 0));
        ResultadosProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultadosProveedoresMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelProveedorLayout = new javax.swing.GroupLayout(panelProveedor);
        panelProveedor.setLayout(panelProveedorLayout);
        panelProveedorLayout.setHorizontalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addGap(24, 24, 24)
                .addComponent(ResultadosProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProveedorLayout.setVerticalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(ResultadosProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contenido.add(panelProveedor);
        panelProveedor.setBounds(6, 153, 511, 37);

        panelCantidad.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Seleccione Cantidad:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        menos.setBackground(new java.awt.Color(24, 50, 77));
        menos.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        menos.setForeground(new java.awt.Color(255, 255, 255));
        menos.setText("-");
        menos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menos.setBorderPainted(false);
        menos.setFocusPainted(false);
        menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosActionPerformed(evt);
            }
        });

        mas.setBackground(new java.awt.Color(24, 50, 77));
        mas.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        mas.setForeground(new java.awt.Color(255, 255, 255));
        mas.setText("+");
        mas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mas.setBorderPainted(false);
        mas.setFocusPainted(false);
        mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masActionPerformed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));
        txtCantidad.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(menos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(menos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout panelCantidadLayout = new javax.swing.GroupLayout(panelCantidad);
        panelCantidad.setLayout(panelCantidadLayout);
        panelCantidadLayout.setHorizontalGroup(
            panelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCantidadLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        panelCantidadLayout.setVerticalGroup(
            panelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCantidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCantidadLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contenido.add(panelCantidad);
        panelCantidad.setBounds(6, 196, 497, 62);

        jPanel2.setBackground(new java.awt.Color(24, 50, 77));
        jPanel2.setPreferredSize(new java.awt.Dimension(348, 31));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(184, 184, 184))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        contenido.add(jPanel2);
        jPanel2.setBounds(0, 0, 530, 31);

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

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        ProductoDto productoS = (ProductoDto) ResultadosProductos.getSelectedItem();
        ProductoProveedorDto proveedorS = (ProductoProveedorDto) this.ResultadosProveedores.getSelectedItem();
        
        ProductoCompradoDto productoC = new ProductoCompradoDto(productoS.getNombre(), productoS.getCodigo(), proveedorS.getProveedor().getNombre(), this.cantidad, proveedorS.getPrecioP());
        
        agregar.agregarCompraLista(productoC);
        
        FrameOrden.Contenido.removeAll();
        
        ValidarInfo va = new ValidarInfo();
        
        FrameOrden.Contenido.add(va.traerContenido());
        
        FrameOrden.Contenido.revalidate();
        FrameOrden.Contenido.repaint();
        
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masActionPerformed
        if (cantidad > 0 && cantidad < 10) {
            cantidad++;

            this.txtCantidad.setText(String.valueOf(cantidad));
        }


    }//GEN-LAST:event_masActionPerformed

    private void menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosActionPerformed
        if (cantidad > 1 && cantidad < 11) {
            cantidad--;
            this.txtCantidad.setText(String.valueOf(cantidad));
        }


    }//GEN-LAST:event_menosActionPerformed

    public javax.swing.JPanel traerContenido() {
        return this.contenido;
    }
    
    public void posicion(GenerarOrden orden){
    this.FrameOrden = orden;
    }
    
    private void ResultadosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultadosProductosActionPerformed
        
    }//GEN-LAST:event_ResultadosProductosActionPerformed

    private void ResultadosProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultadosProductosMouseClicked
        
    }//GEN-LAST:event_ResultadosProductosMouseClicked

    private void ResultadosProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultadosProveedoresMouseClicked
        
    }//GEN-LAST:event_ResultadosProveedoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ProductoDto> ResultadosProductos;
    private javax.swing.JComboBox<ProductoProveedorDto> ResultadosProveedores;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JPanel contenido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton mas;
    private javax.swing.JButton menos;
    private javax.swing.JPanel panelCantidad;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JPanel panelProveedor;
    private javax.swing.JLabel txtCantidad;
    private javax.swing.JTextField txtProductoBuscado;
    // End of variables declaration//GEN-END:variables
}
