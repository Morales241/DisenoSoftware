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
    
    
    @Override
    public boolean inicioSesion(String usuario, String contraseña){
        
        if (usuario.equals("root") && contraseña.equals("admin")) {
            return true;
        }
        return false;
    }
    
}
