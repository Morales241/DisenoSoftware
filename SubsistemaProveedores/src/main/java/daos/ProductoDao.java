/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ProductoDao {
    
    private List<Producto> listaProductos = Arrays.asList(
        new Producto(1L, "132321", "Jeringa"),
        new Producto(2L, "132322", "Guantes Médicos"),
        new Producto(3L, "132323", "Bisturí"),
        new Producto(4L, "132323", "Termómetro"),
        new Producto(5L, "132325", "Estetoscopio"),
        new Producto(6L, "132326", "Tensiómetro"),
        new Producto(7L, "132327", "Vendaje"),
        new Producto(8L, "132328", "Gasas"),
        new Producto(9L, "132329", "Espejo bucal"),
        new Producto(10L, "132330", "Pinzas"),
        new Producto(11L, "132331", "Sonda Foley"),
        new Producto(12L, "132332", "Electrocardiógrafo"),
        new Producto(13L, "132333", "Mascarilla de oxígeno"),
        new Producto(14L, "132334", "Camilla"),
        new Producto(15L, "132335", "Desfibrilador"),
        new Producto(16L, "132336", "Microscopio"),
        new Producto(17L, "132337", "Tubo de ensayo"),
        new Producto(18L, "132338", "Bata de hospital"),
        new Producto(19L, "132339", "Silla de ruedas"),
        new Producto(20L, "132340", "Respirador artificial")
    );

    public ProductoDao() {
        
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
