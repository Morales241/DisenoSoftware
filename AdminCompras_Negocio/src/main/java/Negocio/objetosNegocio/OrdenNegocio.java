/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.objetosNegocio;

import Entidades.FinanzasJpaController;
import Entidades.OrdenCompra;
import Entidades.ProComprado;
import Entidades.ProCompradoJpaController;
import Entidades.Producto;
import Entidades.ProductoJpaController;
import Entidades.pro_Pro;
import Entidades.pro_ProJpaController;
import Negocio.dto.ProductoCompradoDto;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import java.text.Format.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlon
 */
public class OrdenNegocio implements IOrdenNegocio {

    private JLabel tituloTablas = new JLabel();
    private JLabel tablitaSP = new JLabel();
    private JLabel tablePersonas = new JLabel();

    @Override
    public void realizarOrden(List<ProductoCompradoDto> prdsDto) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<ProComprado> productos = new ArrayList();

        prdsDto.forEach(ProductoCompradoDto -> {

            productos.add(new ProComprado(ProductoCompradoDto.getNombre(), ProductoCompradoDto.getCodigo(),
                    ProductoCompradoDto.getProveedor(), ProductoCompradoDto.getCantidad(), ProductoCompradoDto.getPrecio()));
        });

        OrdenCompra oc = new OrdenCompra();
        oc.setFechaExpedicion(Calendar.getInstance());
        oc.setProductos(productos);
        double total = 0;
        for (ProComprado p : productos) {
            total += p.getCantidad() * p.getPrecio();
        }
        oc.setTotal(total);

        for (ProComprado p : productos) {
            p.setOrden(oc);
        }
        em.persist(oc);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        ProductoJpaController pjc = new ProductoJpaController();

        List<Producto> productos = pjc.findProductoEntities();
        List<ProductoDto> productosDto = new ArrayList<>();
        for (Producto p : productos) {
            productosDto.add(new ProductoDto(p.getId(), p.getNombre(), p.getCodigo()));
        }
        return productosDto;
    }

    @Override
    public List<ProductoProveedorDto> obtenerProveedores(Long idProducto) {
        pro_ProJpaController ppjc = new pro_ProJpaController();

        List<pro_Pro> pplist = ppjc.findpro_ProEntities();

        List<pro_Pro> provlist = new ArrayList<>();

        for (pro_Pro pp : pplist) {
            if (pp.getProducto().getId() == idProducto) {
                provlist.add(pp);
            }
        }

        List<ProductoProveedorDto> provlistdto = new ArrayList<>();

        for (pro_Pro p : provlist) {
            provlistdto.add(new ProductoProveedorDto(p.getPrecioP(), p.getStock(),
                    new ProductoDto(p.getProducto().getId(), p.getProducto().getNombre(), p.getProducto().getCodigo()),
                    new ProveedorDto(p.getProveedor().getId(), p.getProveedor().getNombre(), p.getProveedor().getTelefono())));
        }

        return provlistdto;
    }

    @Override
    public ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor) {
        pro_ProJpaController ppjc = new pro_ProJpaController();
        List<pro_Pro> pplist = ppjc.findpro_ProEntities();

        for (pro_Pro pp : pplist) {
            if (idProducto == pp.getProducto().getId() && idProveedor == pp.getProveedor().getId()) {
                return new ProductoProveedorDto(pp.getPrecioP(), pp.getStock(), new ProductoDto(pp.getProducto().getId(), pp.getProducto().getNombre(), pp.getProducto().getCodigo()), new ProveedorDto(pp.getProveedor().getNombre(), pp.getProveedor().getTelefono()));
            }
        }

        return null;
    }

    @Override
    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra) {
        List<ProductoDto> listaProductos = new ArrayList<>();
        for (ProductoDto pdto : this.obtenerProductos()) {
            if (pdto.getNombre().contains(palabra)) {
                listaProductos.add(pdto);
            }
        }
        return listaProductos;
    }

    @Override
    public boolean verificarPresupuesto(Double cantidad) {
        FinanzasJpaController fjc = new FinanzasJpaController();
        if (cantidad < fjc.findFinanzas(0L).getFondoMonetario()) {
            return false;
        }
        return true;
    }

    @Override
    public List<ProductoCompradoDto> obtenerProductosPorAgotarse() {
        ProCompradoJpaController pcjc = new ProCompradoJpaController();
        List<ProComprado> listaProductosComprados = pcjc.findProCompradoEntities();
        List<ProductoCompradoDto> listaProductosPorAgotarse = new ArrayList<>();

        for (ProComprado pc : listaProductosComprados) {
            if (pc.getCantidad() < 3) {
                listaProductosPorAgotarse.add(new ProductoCompradoDto(pc.getNombre(), pc.getCodigo(), pc.getProveedor(), pc.getCantidad(), pc.getPrecio()));
            }
        }

        return listaProductosPorAgotarse;
    }

    @Override
    public void insercion() {
        pro_ProJpaController ppjc = new pro_ProJpaController();

        ppjc.insercion();
    }

    public void llenarTabla(List<ProductoCompradoDto> lista, JTable tabla) {
        // Crear un modelo de tabla y establecerlo en el JTable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nombre","Codigo", "Proveedor", "Costo", "cantidad", "Total"});
        
        if (lista.isEmpty()) {
            System.out.println("No se encontraron productos");
        }else{
            for (ProductoCompradoDto p : lista) {
                model.addRow(new Object[]{p.getNombre(), p.getCodigo(), p.getProveedor(),p.getPrecio(), p.getCantidad(), p.getPrecio()*p.getCantidad()});
            }
        }
        
    }
}
