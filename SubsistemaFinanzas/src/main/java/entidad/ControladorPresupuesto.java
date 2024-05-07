/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

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
public class ControladorPresupuesto {

    private static ControladorPresupuesto instancia; 

    private Double fondoMonetario;

    private ControladorPresupuesto() {
        this.fondoMonetario = Math.random() * (5000 - 1000) + 1000;
    }

    public static ControladorPresupuesto getInstance() {
        if (instancia == null) {
            instancia = new ControladorPresupuesto();
        }
        return instancia;
    }
    public Double getFondoMonetario() {
        return fondoMonetario;
    }

    public void setFondoMonetario(Double fondoMonetario) {
        this.fondoMonetario = fondoMonetario;
    }

    

}