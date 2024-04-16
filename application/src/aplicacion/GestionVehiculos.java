/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;
/**
 *
 * @author grupo2b
 */
public class GestionVehiculos{
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionVehiculos(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }
    /*
    public ArrayList<Vehiculo> obtenerVehiculos(Integer id, String titulo, String isbn, String autor){
        return fbd.consultarCatalogo(id, titulo, isbn, autor);
    }

    public void visualizarVehiculo(String matricula){
        java.util.List<String> restoCategorias;
        java.util.List<Ejemplar> ejemplares;
        Libro l;
        l=fbd.consultarLibro(idLibro);
        restoCategorias=fbd.obtenerRestoCategorias(idLibro);
        fgui.visualizaLibro(l, restoCategorias);
    }

    public void nuevoVehiculo(){
        java.util.List<String> restoCategorias = new java.util.ArrayList<String> ();

        for(Categoria c:fbd.consultarCategorias()){
            restoCategorias.add(c.getNombre());
        }

        fgui.nuevoLibro(restoCategorias);
    }
    
    public Integer actualizarVehiculo(Libro l){
        
       Integer idLibro;

       if (l.getIdLibro()==null)
           idLibro=fbd.insertarLibro(l);
       else{
          fbd.modificarLibro(l);
          idLibro=l.getIdLibro();
       }

       return idLibro;
    }

    public void borrarVehiculo(Integer idLibro){
       fbd.borrarLibro(idLibro);
    }
    */

}
