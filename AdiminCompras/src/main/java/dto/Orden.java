/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author marlon
 */
public class Orden {
    
    private Long id;
    private List<Producto> listaProductos;
    private List<Proveedor> listaProveedores;

    public Orden() {
    }

    public Orden(Long id, List<Producto> listaProductos, List<Proveedor> listaProveedores) {
        this.id = id;
        this.listaProductos = listaProductos;
        this.listaProveedores = listaProveedores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }
    
}
