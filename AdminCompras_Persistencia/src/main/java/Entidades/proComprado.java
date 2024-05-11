package Entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author jesusmr
 */
public class proComprado {

    private ObjectId id;
    private String nombre;
    private String codigo;
    private String proveedor;
    private Integer cantidad;
    private Double precio;

    public proComprado() {
    }

    public proComprado(String nombre, String codigo, String proveedor, Integer cantidad, Double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
