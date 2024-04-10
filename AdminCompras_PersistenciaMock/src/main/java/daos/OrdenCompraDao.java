/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.OrdenCompra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlon
 */
public class OrdenCompraDao {
    
    private List<OrdenCompra> listaOrdenesCompra;

    public OrdenCompraDao() {
        this.listaOrdenesCompra = new ArrayList();
    }
    
    public List<OrdenCompra> obtenerOrdenesCompra() {
        return this.listaOrdenesCompra;
    }
    
    public OrdenCompra obtenerOrdenCompraPorId(Long id) {
        OrdenCompra ordenCompra = null;
        
        for(OrdenCompra p: this.listaOrdenesCompra) {
            if (id == p.getId()) {
                ordenCompra = p;            }
        }
        
        return ordenCompra;
    }
    
    public void agregarOrdenCompra(OrdenCompra ordenCompra) {
        Long ultimoId = this.obtenerOrdenCompraPorId(Long.valueOf(String.valueOf(this.listaOrdenesCompra.size()))).getId();
        ordenCompra.setId(ultimoId + 1);
        this.listaOrdenesCompra.add(ordenCompra);
    }
    
    public void eliminarProductoComprado(Long id) {
        for (int i = 0; i < this.listaOrdenesCompra.size(); i++) {
            if (id == this.listaOrdenesCompra.get(i).getId()) {
                this.listaOrdenesCompra.remove(i);
                break;
            }
        }
    }
    
}
