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
        listaProductos.add(new Producto(1L, "132321", "Jeringa"));
        listaProductos.add(new Producto(2L, "132322", "Guantes Médicos"));
        listaProductos.add(new Producto(3L, "132323", "Bisturí"));
        listaProductos.add(new Producto(4L, "132323", "Termómetro"));
        listaProductos.add(new Producto(5L, "132325", "Estetoscopio"));
        listaProductos.add(new Producto(6L, "132326", "Tensiómetro"));
        listaProductos.add(new Producto(7L, "132327", "Vendaje"));
        listaProductos.add(new Producto(8L, "132328", "Gasas"));
        listaProductos.add(new Producto(9L, "132329", "Espejo bucal"));
        listaProductos.add(new Producto(10L, "132330", "Pinzas"));
        listaProductos.add(new Producto(11L, "132331", "Sonda Foley"));
        listaProductos.add(new Producto(12L, "132332", "Electrocardiógrafo"));
        listaProductos.add(new Producto(13L, "132333", "Mascarilla de oxígeno"));
        listaProductos.add(new Producto(14L, "132334", "Camilla"));
        listaProductos.add(new Producto(15L, "132335", "Desfibrilador"));
        listaProductos.add(new Producto(16L, "132336", "Microscopio"));
        listaProductos.add(new Producto(17L, "132337", "Tubo de ensayo"));
        listaProductos.add(new Producto(18L, "132338", "Bata de hospital"));
        listaProductos.add(new Producto(19L, "132339", "Silla de ruedas"));
        listaProductos.add(new Producto(20L, "132340", "Respirador artificial"));
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
