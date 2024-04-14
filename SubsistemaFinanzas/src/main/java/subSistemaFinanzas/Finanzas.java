/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaFinanzas;

import entidad.Presupuesto;


/**
 *
 * @author tacot
 */
public class Finanzas implements IFinanzas{

    Presupuesto pp = new Presupuesto();

    public Finanzas() {
    }
    
    @Override
    public boolean verificarPresupuesto(Double cantidad) {
        //en vez del if es mas simple sis lo hacemos así
        return cantidad <= pp.getFondoMonetario();
    }

}
