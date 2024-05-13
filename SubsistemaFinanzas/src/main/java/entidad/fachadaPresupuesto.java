/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author tacot
 */
public class fachadaPresupuesto implements IFachadaPresupuesto{
    private static fachadaPresupuesto instancia; 

    private ControladorPresupuesto presupuesto; 

    private fachadaPresupuesto() { 
        presupuesto = ControladorPresupuesto.getInstance();
    }

    public static fachadaPresupuesto getInstance() {
        if (instancia == null) {
            instancia = new fachadaPresupuesto();
        }
        return instancia;
    }

    @Override
    public double trarerPresupuesto() {
        return presupuesto.getFondoMonetario();
    }

    @Override
    public void darPresupuesto(double pre) {
        presupuesto.setFondoMonetario(pre);
    }
    
}
