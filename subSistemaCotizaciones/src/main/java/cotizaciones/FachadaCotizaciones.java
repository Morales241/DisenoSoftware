/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cotizaciones;

import Negocio.dto.ProductoProveedorDto;

/**
 *
 * @author tacot
 */
public class FachadaCotizaciones implements IFachadaCotizaciones{

    controladorCotizaciones control = new controladorCotizaciones();

    public FachadaCotizaciones() {
    }

    @Override
    public ProductoProveedorDto mejorProveedor(Long id) {
        return control.mejorProveedor(id);
    }
}
