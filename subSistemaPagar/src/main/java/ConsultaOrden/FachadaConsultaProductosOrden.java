/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultaOrden;

import EntidadesMock.proCompradoMock;
import java.util.List;

/**
 *
 * @author tacot
 */
public class FachadaConsultaProductosOrden implements IconsultaProOrden{
    
subSistemaConsultaOrdenesBO subSistema = new subSistemaConsultaOrdenesBO();


    @Override
    public List<proCompradoMock>  consultarProductosOrden(int index) {
        return subSistema.consultarProductosDeUnaOrden(index);
    }
     
}
