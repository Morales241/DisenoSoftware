/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoEntregadoDto;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author tacot
 */
public class FachadaLLenarTabla implements IFachadaLlenarTabla{

    public FachadaLLenarTabla() {
    }

    ControladorLlenarTabla llenado = new ControladorLlenarTabla();
    @Override
    public void llenarTabla(List<ProductoEntregadoDto> lista, JTable tabla) {
        llenado.llenarTabla(lista, tabla);
    }
    
}
