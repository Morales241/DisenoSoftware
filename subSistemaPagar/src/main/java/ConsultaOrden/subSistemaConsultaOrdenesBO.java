/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultaOrden;

import DaosMock.DaoOrdenMock;
import EntidadesMock.proCompradoMock;
import java.util.List;

/**
 *
 * @author tacot
 */
public class subSistemaConsultaOrdenesBO {
    
    
    public List<proCompradoMock> consultarProductosDeUnaOrden(int index){
    return ordenDao.consultarProductosOrden(index);
    }
    
}
