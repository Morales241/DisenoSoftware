/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cotizacion;

import GenerarOrden.AgregarProducto;
import GenerarOrden.GenerarOrden;
import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentacion.Inicio;
import subSistemaAgregarProducto.IagregarProductoBO;
import subSistemaAgregarProducto.fachadaAgregarProductos;
import subSistemaConsultarProducto.IConsultarProducto;
import subSistemaConsultarProducto.IFachadaCoinsidencias;
import subSistemaConsultarProducto.fachadaCoinsidencias;
import subSistemaConsultarProducto.fachadaConsultarProducto;
import subsistema.IConsultarProveedores;
import subsistema.fachadaConsultarProveedores;

/**
 *
 * @author tacot
 */
public class Cotizacion extends javax.swing.JFrame {

    private IFachadaCoinsidencias coin = new fachadaCoinsidencias();

    private Inicio inicio;

    private int cantidad = 1;

    private double pc = 0;

    private String palabra = "";

    private List<ProductoDto> Productos = new ArrayList<>();

    private IConsultarProducto consultaP = new fachadaConsultarProducto();

    private IConsultarProveedores proveedoresConsulta = new fachadaConsultarProveedores();

    private IagregarProductoBO agregar = new fachadaAgregarProductos();

    private ProductoDto productoS;

    /**
     * Creates new form Cotizacion
     */
    public Cotizacion(Inicio ini) {
        this.inicio = ini;
        
        initComponents();

        this.Productos = consultaP.obtenerProductos();

        this.panelPR.setVisible(false);
        
        this.PanelPro.setVisible(false);

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

                Productos = coin.obtenerCoincidenciasProductos(palabra);

                for (ProductoDto p : Productos) {
                    ResultadosProductos.addItem(p);
                }

                if (palabra.equals("")) {
                    panelPR.setVisible(false);
                    PanelPro.setVisible(false);
                } else {
                    if (ResultadosProductos.getItemCount() == 0) {
                        panelPR.setVisible(false);
                        PanelPro.setVisible(false);
                    } else {

                        panelPR.setVisible(true);
                        PanelPro.setVisible(true);
                    }
                }

            }
        });

        this.ResultadosProductos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ResultadosProveedores.removeAllItems();

                    productoS = (ProductoDto) ResultadosProductos.getSelectedItem();

                    try {
                        for (ProductoProveedorDto p : proveedoresConsulta.obtenerProveedores(productoS.getId())) {
                            ResultadosProveedores.addItem(p);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    ProductoProveedorDto propro = (ProductoProveedorDto) ResultadosProveedores.getSelectedItem();

                    pc = propro.getPrecioP();

                    PrecioUnitario.setText(String.valueOf(pc));

                    total.setText(String.valueOf(cantidad * pc));

                }
            }
        });

        this.ResultadosProveedores.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    ProductoProveedorDto propro = (ProductoProveedorDto) ResultadosProveedores.getSelectedItem();

                    pc = propro.getPrecioP();

                    PrecioUnitario.setText(String.valueOf(pc));

                    total.setText(String.valueOf(cantidad * pc));
                }
            }
        });

    }

    public Cotizacion() {
        initComponents();

        this.Productos = consultaP.obtenerProductos();

        this.panelPR.setVisible(false);
        this.PanelPro.setVisible(false);
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

                Productos = coin.obtenerCoincidenciasProductos(palabra);

                for (ProductoDto p : Productos) {
                    ResultadosProductos.addItem(p);
                }

                if (palabra.equals("")) {
                    panelPR.setVisible(false);
                    PanelPro.setVisible(false);

                } else {
                    if (ResultadosProductos.getItemCount() == 0) {
                        panelPR.setVisible(false);
                        PanelPro.setVisible(false);

                    } else {
                        panelPR.setVisible(true);
                        PanelPro.setVisible(true);

                    }
                }

            }
        });

        this.ResultadosProductos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ResultadosProveedores.removeAllItems();

                    ProductoDto productoS = (ProductoDto) ResultadosProductos.getSelectedItem();
                    ProductoProveedorDto propro = null;
                    try {
                        for (ProductoProveedorDto p : proveedoresConsulta.obtenerProveedores(productoS.getId())) {
                            ResultadosProveedores.addItem(p);
                        }

                        propro = (ProductoProveedorDto) ResultadosProveedores.getSelectedItem();

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
        jLabel5 = new javax.swing.JLabel();
        txtProductoBuscado = new javax.swing.JTextField();
        panelPR = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ResultadosProductos = new javax.swing.JComboBox<>();
        PanelPro = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        MejorProveedor = new javax.swing.JButton();
        ResultadosProveedores = new javax.swing.JComboBox<>();
        PrecioUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        Agregar = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();
        menos = new javax.swing.JButton();
        mas = new javax.swing.JButton();
        txtCantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setPreferredSize(new java.awt.Dimension(675, 500));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre del Producto:");

        txtProductoBuscado.setBackground(new java.awt.Color(24, 50, 77));
        txtProductoBuscado.setForeground(new java.awt.Color(255, 255, 255));

        panelPR.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Seleccione Producto:");

        ResultadosProductos.setBackground(new java.awt.Color(24, 50, 77));
        ResultadosProductos.setForeground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout panelPRLayout = new javax.swing.GroupLayout(panelPR);
        panelPR.setLayout(panelPRLayout);
        panelPRLayout.setHorizontalGroup(
            panelPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPRLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(ResultadosProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPRLayout.setVerticalGroup(
            panelPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ResultadosProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        PanelPro.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Selecciones proveedor:");

        MejorProveedor.setBackground(new java.awt.Color(24, 50, 77));
        MejorProveedor.setForeground(new java.awt.Color(255, 255, 255));
        MejorProveedor.setText("Mejor Proveedor");
        MejorProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MejorProveedorActionPerformed(evt);
            }
        });

        ResultadosProveedores.setBackground(new java.awt.Color(24, 50, 77));
        ResultadosProveedores.setForeground(new java.awt.Color(255, 255, 255));
        ResultadosProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultadosProveedoresActionPerformed(evt);
            }
        });

        PrecioUnitario.setEditable(false);
        PrecioUnitario.setBackground(new java.awt.Color(24, 50, 77));
        PrecioUnitario.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Precio unitario:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Seleccione Cantidad:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Total:");

        total.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        total.setForeground(new java.awt.Color(0, 0, 0));

        Agregar.setBackground(new java.awt.Color(24, 50, 77));
        Agregar.setForeground(new java.awt.Color(255, 255, 255));
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(menos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout PanelProLayout = new javax.swing.GroupLayout(PanelPro);
        PanelPro.setLayout(PanelProLayout);
        PanelProLayout.setHorizontalGroup(
            PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProLayout.createSequentialGroup()
                .addGroup(PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)))
                .addGroup(PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResultadosProveedores, 0, 257, Short.MAX_VALUE)
                    .addComponent(PrecioUnitario)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MejorProveedor)
                .addGap(61, 61, 61))
        );
        PanelProLayout.setVerticalGroup(
            PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProLayout.createSequentialGroup()
                .addComponent(MejorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelProLayout.createSequentialGroup()
                        .addGroup(PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ResultadosProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(PrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addGap(42, 42, 42)
                .addGroup(PanelProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtProductoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProductoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void ResultadosProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultadosProductosMouseClicked

    }//GEN-LAST:event_ResultadosProductosMouseClicked

    private void ResultadosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultadosProductosActionPerformed

    }//GEN-LAST:event_ResultadosProductosActionPerformed

    private void ResultadosProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultadosProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResultadosProveedoresActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if (this.ResultadosProductos.getSelectedItem() != null || this.ResultadosProductos != null) {

            ProductoDto productoS = (ProductoDto) ResultadosProductos.getSelectedItem();

            ProductoProveedorDto proveedorS = (ProductoProveedorDto) this.ResultadosProveedores.getSelectedItem();

            ProductoCompradoDto productoC = null;

            try {

                productoC = new ProductoCompradoDto(productoS.getNombre(), productoS.getCodigo(), proveedorS.getProveedor().getNombre(), this.cantidad, proveedorS.getPrecioP());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No hay proveedor o producto seleccionado ");
            }

            agregar.agregarCompraLista(productoC);

            this.inicio.Contenido.removeAll();

            GenerarOrden gO = new GenerarOrden();

            this.inicio.Contenido.add(gO.traerContenido());
            this.inicio.Contenido.revalidate();
            this.inicio.Contenido.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No hay proveedor o producto seleccionado ");

        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosActionPerformed
        if (cantidad > 1 && cantidad < 11) {
            cantidad--;

            this.txtCantidad.setText(String.valueOf(cantidad));
            total.setText(String.valueOf(cantidad * pc));
        }
    }//GEN-LAST:event_menosActionPerformed

    private void masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masActionPerformed
        if (cantidad > 0 && cantidad < 10) {
            cantidad++;

            this.txtCantidad.setText(String.valueOf(cantidad));
            total.setText(String.valueOf(cantidad * pc));
        }
    }//GEN-LAST:event_masActionPerformed

    private void MejorProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MejorProveedorActionPerformed
        productoS = (ProductoDto) ResultadosProductos.getSelectedItem();
        List<ProductoProveedorDto> proveedores = new ArrayList<>();

        try {
            for (ProductoProveedorDto p : proveedoresConsulta.obtenerProveedores(productoS.getId())) {
                proveedores.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        ProductoProveedorDto mejorPro = proveedores.get(0);
        for (int i = 1; i < proveedores.size(); i++) {
            if (proveedores.get(i).getPrecioP() < mejorPro.getPrecioP()) {
                mejorPro = proveedores.get(i);
            }
        }

        ResultadosProveedores.removeAllItems();

        ResultadosProveedores.addItem(mejorPro);

        pc = mejorPro.getPrecioP();

        PrecioUnitario.setText(String.valueOf(pc));

        total.setText(String.valueOf(cantidad * pc));

    }//GEN-LAST:event_MejorProveedorActionPerformed

    public javax.swing.JPanel traerContenido() {
        return this.contenido;
    }

    public void posicion(Inicio ini) {
        this.inicio = ini;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton MejorProveedor;
    private javax.swing.JPanel PanelPro;
    private javax.swing.JTextField PrecioUnitario;
    private javax.swing.JComboBox<ProductoDto> ResultadosProductos;
    private javax.swing.JComboBox<ProductoProveedorDto> ResultadosProveedores;
    private javax.swing.JPanel contenido;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton mas;
    private javax.swing.JButton menos;
    private javax.swing.JPanel panelPR;
    private javax.swing.JLabel total;
    private javax.swing.JLabel txtCantidad;
    private javax.swing.JTextField txtProductoBuscado;
    // End of variables declaration//GEN-END:variables
}
