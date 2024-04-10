/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaFinanzas;


/**
 *
 * @author tacot
 */
public class Finanzas implements IFinanzas{

    @Override
    public boolean verificarPresupuesto(Double cantidad) {
        if (cantidad <= 5000) {
            return true;
        }
        return false;
//        FinanzasJpaController fjc = new FinanzasJpaController();
//        if (cantidad < fjc.findFinanzas(0L).getFondoMonetario()) {
//            return false;
//        }
//        return true;
    }

}
