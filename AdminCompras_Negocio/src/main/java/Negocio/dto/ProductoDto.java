/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.dto;

import java.util.List;

/**
 *
 * @author marlon
 */
public class ProductoDto {
    
    private Long id;
    
    private String nombre;

    public ProductoDto() {
    }

    public ProductoDto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}