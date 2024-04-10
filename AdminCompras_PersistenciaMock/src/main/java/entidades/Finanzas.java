/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author marlon
 */
public class Finanzas {
    
    private Long id;
    private Double fondoMonetario;

    public Finanzas() {
    }

    public Finanzas(Long id, Double fondoMonetario) {
        this.id = id;
        this.fondoMonetario = fondoMonetario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFondoMonetario() {
        return fondoMonetario;
    }

    public void setFondoMonetario(Double fondoMonetario) {
        this.fondoMonetario = fondoMonetario;
    }
    
}
