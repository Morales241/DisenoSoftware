/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author tacot
 */
public class fachadaPresupuesto implements Ipresupuesto{
    Presupuesto presupuesto = new Presupuesto();
    public fachadaPresupuesto() {
    }

    @Override
    public double trarerPresupuesto() {
        return presupuesto.getFondoMonetario();
    }
    
}
