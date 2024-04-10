/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ProductoDao {
    
    private List<Producto> listaProductos;

    public ProductoDao() {
        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(1L, "132328", "Microscopio"));
        listaProductos.add(new Producto(2L, "132326", "Camilla"));
        listaProductos.add(new Producto(3L, "132322", "Pinzas"));
    }
    
    public List<Producto> obtenerProductos() {
        return this.listaProductos;
    }
    
    public Producto obtenerProductoPorId(Long id) {
        Producto producto = null;
        
        for(Producto p: this.listaProductos) {
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
            if (id == this.listaProductos.get(i).getId()) {
                this.listaProductos.remove(i);
                break;
            }
        }   
    }
    
    
    
}
