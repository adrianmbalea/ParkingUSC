/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import aplicacion.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author grupo2b
 */
public class DAOParkings extends AbstractDAO {
    
    public DAOParkings (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    // recibe un campus y un centro, y devuelve el parking
    public Parking getParking(Campus campus, Centro centro) {
        Parking resultado = null;
        Connection con;
        PreparedStatement stmParking=null;
        ResultSet rsParking;

        con=super.getConexion();

        try {
        stmParking =con.prepareStatement("select * from parkings where campus = ? and centro = ?");
        stmParking.setString(1, campus.getNombre());
        stmParking.setString(2, centro.getNombre());
        rsParking=stmParking.executeQuery();
        while (rsParking.next())
        {
            resultado = new Parking(campus, centro, rsParking.getInt("capacidad"), rsParking.getInt("maximoPrivadas"));
            
        }


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmParking.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    // devuelve los centros distintos que hay en un campus concreto
    public ArrayList<Centro> listarCentros(String campus){
        ArrayList<Centro> resultado = new ArrayList<>();
        Connection con;
        PreparedStatement stmCentro=null;
        ResultSet rsCentro;

        con=super.getConexion();

        try {
        stmCentro =con.prepareStatement("select distinct centro from parkings where campus = ?");
        stmCentro.setString(1, campus);
        rsCentro=stmCentro.executeQuery();
        while (rsCentro.next())
        {
            resultado.add(new Centro(rsCentro.getString("centro")));
            
        }


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCentro.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    // Devuelve los distintos campus que hay en la base de datos (almacenando tambien sus centros)
    public ArrayList<Campus> listarCampus(){
        ArrayList<Campus> resultado = new ArrayList<>();
        Connection con;
        PreparedStatement stmCampus=null;
        ResultSet rsCampus;

        con=super.getConexion();

        try {
        stmCampus =con.prepareStatement("select distinct campus from parkings");
        rsCampus=stmCampus.executeQuery();
        while (rsCampus.next())
        {
            Campus newCampus = new Campus(rsCampus.getString("campus"), new ArrayList<>());
            resultado.add(newCampus);
            for(Centro i: listarCentros(newCampus.getNombre())){
                newCampus.addCentro(i);
            }
            
        }


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCampus.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    // funcion que recibe un numero de plaza, un parking y una hora y devuelve en que estado se encuentra
    public String verPlaza(Integer numPlaza, Parking parking, Timestamp fechaEntrada, Timestamp fechaSalida){
            String resultado=null;
            Connection con;
            PreparedStatement stmVerParking=null;
            ResultSet rsVerParking;

            con=this.getConexion();

            try {
            stmVerParking=con.prepareStatement("SELECT \n" +
"  CASE \n" +
"    WHEN a.matriculaVehiculo IS NOT NULL THEN 'ocupada'\n" +
"    WHEN r.dniMiembroUSC IS NOT NULL THEN 'reservada'\n" +
"    WHEN s.dniPDI IS NOT NULL THEN 'asignada'\n" +
"    ELSE 'libre'\n" +
"  END AS estado_plaza\n" +
"FROM \n" +
"  (SELECT \n" +
"    campusParking, centroParking, id, tamanho\n" +
"   FROM \n" +
"    plazasPublicas\n" +
"   WHERE \n" +
"    campusParking = ? AND centroParking = ? AND id = ?\n" +
"   UNION ALL\n" +
"   SELECT \n" +
"    campusParking, centroParking, id, tamanho\n" +
"   FROM \n" +
"    plazasPrivadas\n" +
"   WHERE \n" +
"    campusParking = ? AND centroParking = ? AND id = ?) AS p\n" +
"  LEFT JOIN aparcar a ON p.campusParking = a.campusParking AND p.centroParking = a.centroParking AND p.id = a.idPlaza AND a.fechaEntrada <= ? AND (a.fechaSalida IS NULL OR a.fechaSalida >= ?)\n" +
"  LEFT JOIN reservar r ON p.campusParking = r.campusParking AND p.centroParking = r.centroParking AND p.id = r.idPlaza AND r.fechaInicio <= ? AND r.fechaFin >= ? \n" +
"  LEFT JOIN asignar s ON p.campusParking = s.campusParking AND p.centroParking = s.centroParking AND p.id = s.idPlaza AND s.fechaInicio <= ? AND (s.fechaFin IS NULL OR s.fechaFin >= ?);");
        stmVerParking.setString(1, parking.getCampus().getNombre());
        stmVerParking.setString(2, parking.getCentro().getNombre());
        stmVerParking.setInt(3, numPlaza);
        stmVerParking.setString(4, parking.getCampus().getNombre());
        stmVerParking.setString(5, parking.getCentro().getNombre());
        stmVerParking.setInt(6, numPlaza);
        stmVerParking.setTimestamp(7, fechaSalida);
        stmVerParking.setTimestamp(8, fechaEntrada);
        stmVerParking.setTimestamp(9, fechaSalida);
        stmVerParking.setTimestamp(10, fechaEntrada);
        stmVerParking.setTimestamp(11, fechaSalida);
        stmVerParking.setTimestamp(12, fechaEntrada);
        
        rsVerParking=stmVerParking.executeQuery();
        if(rsVerParking.next()){
           resultado = rsVerParking.getString("estado_plaza");
            System.out.println("Plaza "+numPlaza.toString()+": "+resultado); 
        } 
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVerParking.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    
    
     // funcion que recibe un numero de plaza y un parking y devuelve el tipo de plaza (publica o privada)
    public String verTipoPlaza(Integer numPlaza, Parking parking){
            String resultado=null;
            Connection con;
            PreparedStatement stmVerParking=null;
            ResultSet rsVerParking;

            con=this.getConexion();

            try {
            stmVerParking=con.prepareStatement( "SELECT  " +
"    CASE " +
"        WHEN EXISTS ( " +
"            SELECT * FROM plazasPrivadas  " +
"            WHERE campusParking = ?  " +
"            AND centroParking = ?  " +
"            AND id = ? " +
"        ) THEN 'privada' " +
"        WHEN EXISTS ( " +
"            SELECT * FROM plazasPublicas  " +
"            WHERE campusParking = ?   " +
"            AND centroParking = ? " +
"            AND id = ? " +
"        ) THEN 'publica' " +
"        ELSE 'no encontrada' " +
"    END AS TipoDePlaza  ");
            
            
        stmVerParking.setString(1, parking.getCampus().getNombre());
        stmVerParking.setString(2, parking.getCentro().getNombre());
        stmVerParking.setInt(3, numPlaza);
        
         stmVerParking.setString(4, parking.getCampus().getNombre());
        stmVerParking.setString(5, parking.getCentro().getNombre());
        stmVerParking.setInt(6, numPlaza);

        
        rsVerParking=stmVerParking.executeQuery();
        if(rsVerParking.next()){
           resultado = rsVerParking.getString("tipodeplaza");
            
        } 
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVerParking.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    
}
