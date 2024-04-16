/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.*;
import baseDatos.*;
/**
 *
 * @author grupo2b
 */
public class GestionUsuarios {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
    
  public Boolean comprobarAutentificacion(String idUsuario, String clave){
      UsuarioUSC u;

      u=fbd.validarUsuario(idUsuario, clave);
      if (u!=null){
          // Si el usuario esta vetado se devuelve null
          // Para identificarlo en la ventana de autentificacion
          if(u.getRol().equals("vetado") ){
              return null;
          }
          // Modificacion: permitir usuarios normales
          return (u.getRol().equals("usuario") || u.getRol().equals("administrador"));
          
      } else return false;
  }
  
 
  
}
