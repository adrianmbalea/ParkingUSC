/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import baseDatos.*;
import gui.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;


/**
 *
 * @author grupo2b
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionVehiculos gv;
    GestionUsuarios gu;
    
    
 public FachadaAplicacion(){
   fgui=new gui.FachadaGui(this);
   fbd= new baseDatos.FachadaBaseDatos(this);
   gv= new GestionVehiculos(fgui, fbd);
   gu= new GestionUsuarios(fgui, fbd);
 }

 public static void main(String args[]) {
     FachadaAplicacion fa;
     
     fa= new FachadaAplicacion();
     fa.iniciaInterfazUsuario();
 }
 
 public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }

 public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }
 
 public FachadaBaseDatos getFachadaBaseDatos(){
     return this.fbd;
 }
 
 // Devuelve los vehiculos de un usuario determinado
    public ArrayList<Vehiculo> vehiculosUsuario(UsuarioUSC usuario){
        return fbd.vehiculosUsuario(usuario);
    }
 /*
public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor, String idioma){
  return cl.obtenerLibros(id, titulo,  isbn,  autor, idioma);
};

public void visualizarLibro(Integer idLibro){
 cl.visualizarLibro(idLibro);
}

public void nuevoLibro(){
 cl.nuevoLibro();
}

public Integer actualizarLibro(Libro l){
  return cl.actualizarLibro(l);
}

public void borrarLibro(Integer idLibro){
   cl.borrarLibro(idLibro);
}

public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
 cl.actualizarCategoriasLibro(idLibro, categorias);
}

public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar){
  return cl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
}
 */

public Boolean comprobarAutentificacion(String idUsuario, String clave){
  return gu.comprobarAutentificacion(idUsuario, clave); 
}

public ArrayList<Campus> listarCampus(){
    return fbd.listarCampus();
}

 public ArrayList<Centro> listarCentros(String campus){
    return fbd.listarCentros(campus);
}
 
public String verPlaza(Integer numPlaza, Parking parking, Timestamp fechaEntrada, Timestamp fechaSalida){
    return fbd.verPlaza(numPlaza, parking, fechaEntrada, fechaSalida);
}

public Parking getParking(Campus campus, Centro centro){
         return fbd.getParking(campus, centro);
    }

public boolean realizarReserva(Reservar reserva){
        return fbd.realizarReserva(reserva);
    }





}
