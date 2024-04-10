/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ProveedorDao {
    
    private List<Proveedor> listaProveedores;

    public ProveedorDao() {
        listaProveedores = new ArrayList<>();
        listaProveedores.add(new Proveedor(1L, "Carlos García", "644-678-9012"));
        listaProveedores.add(new Proveedor(2L, "Luis Martínes", "644-890-1234"));
        listaProveedores.add(new Proveedor(3L, "Juan Pérez", "644-456-7890"));
    }
    
    public List<Proveedor> obtenerProveedores() {
        return this.listaProveedores;
    }
    
    public Proveedor obtenerProveedorPorId(Long id) {
        Proveedor proveedor = null;
        
        for(Proveedor p: this.listaProveedores) {
            if (id == p.getId()) {
                proveedor = p;            }
        }
        
        return proveedor;
    }
    
    public void agregarProveedor(Proveedor proveedor) {
        Long ultimoId = this.obtenerProveedorPorId(Long.valueOf(String.valueOf(this.listaProveedores.size()))).getId();
        proveedor.setId(ultimoId + 1);
        this.listaProveedores.add(proveedor);
    }
    
    public void eliminarProveedor(Long id) {
        for (int i = 0; i < this.listaProveedores.size(); i++) {
            if (id == this.listaProveedores.get(i).getId()) {
                this.listaProveedores.remove(i);
                break;
            }
        }
    }
    
}
