/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistema;

import Negocio.dto.ProductoCompradoDto;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author tacot
 */
public class FachadaLLenarTabla implements ILlenarTabla{

    public FachadaLLenarTabla() {
    }

    LlenarTabla llenado = new LlenarTabla();
    @Override
    public void llenarTabla(List<ProductoCompradoDto> lista, JTable tabla) {
        llenado.llenarTabla(lista, tabla);
    }
    
}