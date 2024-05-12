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
    private Integer cantidad;

    public proComprado() {
    }

    public proComprado(String nombre, String codigo, Integer cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
