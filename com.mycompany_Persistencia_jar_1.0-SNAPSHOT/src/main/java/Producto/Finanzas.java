package Producto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marlon
 */
@Entity
public class Finanzas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fondo_monetario")
    private Double fondoMonetario;

    public Finanzas() {
    }

    public Finanzas(Double fondoMonetario) {
        this.fondoMonetario = fondoMonetario;
    }

    public Double getFondoMonetario() {
        return fondoMonetario;
    }

    public void setFondoMonetario(Double fondoMonetario) {
        this.fondoMonetario = fondoMonetario;
    }
    
}
