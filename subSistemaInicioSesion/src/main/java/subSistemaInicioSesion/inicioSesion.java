/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subSistemaInicioSesion;


/**
 *
 * @author 
 */
public class inicioSesion implements IInicioSesion{

    public inicioSesion() {
    }
    
    @Override
    public boolean inicioSesion(String usuario, String contraseña){
        
        return usuario.equals("root") && contraseña.equals("admin");
    }
    
}
