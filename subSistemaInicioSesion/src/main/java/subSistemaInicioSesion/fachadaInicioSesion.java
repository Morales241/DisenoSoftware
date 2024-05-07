/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaInicioSesion;

/**
 *
 * @author tacot
 */
public class fachadaInicioSesion implements IFachadaInicioSesion{
    ControladorInicioSesion inicioS = new ControladorInicioSesion();
    public fachadaInicioSesion() {
    }

    @Override
    public boolean inicioSesion(String usuario, String contraseña) {
        return inicioS.inicioSesion(usuario, contraseña);
    }
    
}
