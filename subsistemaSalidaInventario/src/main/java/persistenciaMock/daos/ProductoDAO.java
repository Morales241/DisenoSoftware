/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistenciaMock.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import persistenciaMock.entidades.Producto;

/**
 *
 * @author marlon
 */
public class ProductoDAO {
    
    private static ProductoDAO instancia;
    private List<Producto> listaProductos;

    private ProductoDAO() {
        listaProductos = new ArrayList();
        listaProductos.add(new Producto(1L, "Jeringa", 23, "12351"));
        listaProductos.add(new Producto(2L, "Pinzas", 15, "16451"));
        listaProductos.add(new Producto(3L, "Vendaje", 42, "12284"));
        listaProductos.add(new Producto(4L, "Termómetro", 9, "25932"));
        listaProductos.add(new Producto(5L, "Mascarilla de Oxígeno", 9, "22722"));
        listaProductos.add(new Producto(6L, "Gasas", 12, "52332"));
        listaProductos.add(new Producto(7L, "Bata de Hospital", 5, "74432"));
        listaProductos.add(new Producto(8L, "Guantes Médicos", 31, "43232"));
        listaProductos.add(new Producto(9L, "Bisturí", 24, "46432"));
        listaProductos.add(new Producto(10L, "Camilla", 16, "53632"));
    }
    
    public static ProductoDAO obtenerInstancia() {
        if (instancia == null) {
            instancia = new ProductoDAO();
        }
        return instancia;
    }
    
    public List<Producto> obtenerProductos() {
        return listaProductos;
    }
    
    public Producto obtenerProductoPorId(Long id) {
        Producto producto = null;
        
        for (Producto p: listaProductos) {
            if (id == p.getId()) {
                producto = p;
            }
        }
        
        return producto;
    }
    
    public void agregarProducto(Producto producto) {
        Long ultimoId = this.obtenerProductoPorId(Long.valueOf(String.valueOf(this.listaProductos.size()))).getId();
        producto.setId(ultimoId + 1);
        this.listaProductos.add(producto);
    }
    
    public void eliminarProducto(Long id) {   
        for (int i = 0; i < this.listaProductos.size(); i++) {
            if (Objects.equals(id, this.listaProductos.get(i).getId())) {
                this.listaProductos.remove(i);
                break;
            }
        }   
    }
    
    public void actualizarProducto(Producto producto) {
        eliminarProducto(producto.getId());
        listaProductos.add(producto);
    }
    
}
