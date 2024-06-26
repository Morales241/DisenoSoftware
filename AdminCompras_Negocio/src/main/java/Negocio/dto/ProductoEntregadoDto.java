package Negocio.dto;

/**
 *
 * @author tacot
 */
public class ProductoEntregadoDto {
    private String nombre;

    private String codigo;


    private Integer cantidad;


    public ProductoEntregadoDto(String nombre, String codigo, Integer cantidad) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public ProductoEntregadoDto() {
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
