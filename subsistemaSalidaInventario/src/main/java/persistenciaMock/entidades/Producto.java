/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistenciaMock.entidades;

/**
 *
 * @author marlon
 */
public class Producto {
    
    private Long id;
    private String nombre;
    private int cantidad;
    private String codigo;

    public Producto() {
    }

    public Producto(Long id, String nombre, int cantidad, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
        
}
