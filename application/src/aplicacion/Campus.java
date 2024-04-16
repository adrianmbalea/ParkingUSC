package aplicacion;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author grupo2b
 */
public class Campus {
    private String nombre;
    private ArrayList<Centro> centros;
    
    public Campus (String nombre, ArrayList<Centro> centros){
        this.nombre = nombre;
        this.centros = centros;
    }

    public Campus(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Centro> getCentros() {
        return centros;
    }
    
    public void addCentro(Centro centro){
        this.centros.add(centro);
    }
}
