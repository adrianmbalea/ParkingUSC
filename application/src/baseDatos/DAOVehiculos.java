/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import java.sql.*;
import aplicacion.*;
import java.util.ArrayList;
/**
 *
 * @author grupo2b
 */
public class DAOVehiculos extends AbstractDAO {

    public DAOVehiculos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    // Devuelve los vehiculos de un usuario determinado
    public ArrayList<Vehiculo> vehiculosUsuario(UsuarioUSC usuario){
        
         ArrayList<Vehiculo> vehiculosUsuario = new ArrayList<>();
        Connection con;
        PreparedStatement stmVehiculo=null;
        ResultSet rsVehiculos;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("select * " +
"from vehiculos v  " +
"where v.dnimiembrousc = ?  ");
        stmVehiculo.setString(1, usuario.getDniUsuario());
        rsVehiculos=stmVehiculo.executeQuery();
        while (rsVehiculos.next())
        {
             vehiculosUsuario.add(new Vehiculo(rsVehiculos.getString("matricula"), rsVehiculos.getString("tipo"), rsVehiculos.getString("marca"), 
             rsVehiculos.getString("modelo"), rsVehiculos.getInt("numeroInfracciones")));
        }


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVehiculo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        //System.out.println(vehiculosUsuario);
        return vehiculosUsuario;
        
    }
    
    // Devuelve los datos de aparcar de los vehiculos de un usuario que están aparcados
    public ArrayList<Aparcar> vehiculosAparcados(UsuarioUSC usuario){
        
         ArrayList<Aparcar> vehiculosAparcados = new ArrayList<>();
        Connection con;
        PreparedStatement stmVehiculo=null;
        ResultSet rsVehiculos;

        con=super.getConexion();

        for(Vehiculo v: usuario.getVehiculos())
        try {
        stmVehiculo =con.prepareStatement("select * " +
"from aparcar a " +
"where matriculavehiculo like ? " +
"and fechasalida is null");
        stmVehiculo.setString(1,v.getMatricula());
        rsVehiculos=stmVehiculo.executeQuery();
        while(rsVehiculos.next())
        {
             vehiculosAparcados.add(new Aparcar(rsVehiculos.getTimestamp("fechaentrada"), rsVehiculos.getTimestamp("fechasalida"), rsVehiculos.getInt("preciohora"), 
             v, new Campus(rsVehiculos.getString("campusparking")), new Centro( rsVehiculos.getString("centroparking")), rsVehiculos.getInt("idplaza") ));
        }


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVehiculo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
         return vehiculosAparcados;
        
    }
    
    
    // Retira un vehiculo de vehiculos aparcados
    public boolean retirarVehiculoAparcado(Aparcar aparcar){
        
        Boolean bool = false;
        Connection con;
        PreparedStatement stmVehiculo=null;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("update aparcar set fechaSalida = current_date where matriculavehiculo like ? ;");
        stmVehiculo.setString(1, aparcar.getVehiculo().getMatricula());
        stmVehiculo.executeUpdate();
        bool = true;

        } catch (SQLException e){
          System.out.println(e.getMessage());
          bool = false;
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVehiculo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return bool;
        
    }
    
    // Anhade un vehiculo de un usuario
    public boolean anhadirVehiculo(UsuarioUSC usuario, Vehiculo vehiculo){
        
        Boolean bool = false;
        Connection con;
        PreparedStatement stmVehiculo=null;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) " +
"	values (? , ?, ?, ?, ?, ?);");
        stmVehiculo.setString(1, vehiculo.getMatricula()); stmVehiculo.setString(2, vehiculo.getTipo()); stmVehiculo.setString(3, vehiculo.getMarca());
        stmVehiculo.setString(4, vehiculo.getModelo()); stmVehiculo.setInt(5, vehiculo.getNumeroInfracciones()); stmVehiculo.setString(6, usuario.getDniUsuario());
        stmVehiculo.executeUpdate();
        bool = true;

        } catch (SQLException e){
          System.out.println(e.getMessage());
          bool = false;
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVehiculo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return bool;
        
    }
    
        // Anhade una infraccion a un vehiculo
    public boolean anhadirInfraccion(Vehiculo vehiculo){
        
        Boolean bool = false;
        Connection con;
        PreparedStatement stmVehiculo=null;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("begin transaction; " +
"update vehiculos set numeroInfracciones = numeroInfracciones + 1 where matricula like ?  ; "
                + "commit transaction; ");
        
        stmVehiculo.setString(1, vehiculo.getMatricula());
        
        stmVehiculo.executeUpdate();
        bool = true;

        } catch (SQLException e){
          System.out.println(e.getMessage());
          bool = false;
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVehiculo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return bool;
        
    }
    
        // Anhade un vehiculo a un parking
    public boolean aparcarVehiculo(Aparcar aparcar){
        
        Boolean bool = false;
        Connection con;
        PreparedStatement stmVehiculo=null;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("begin transaction; " +
" " +
"	insert into aparcar (fechaEntrada, fechaSalida, precioHora, matriculaVehiculo, campusParking, centroParking, idPlaza) " +
"	values ( ? , null, 1.47, ? , ? , ? , ?); " +
" " +
"commit transaction;");
        stmVehiculo.setTimestamp(1, aparcar.getFechaEntrada()); stmVehiculo.setString(2, aparcar.getVehiculo().getMatricula());
        stmVehiculo.setString(3, aparcar.getCampus().getNombre()); stmVehiculo.setString(4, aparcar.getCentro().getNombre());
        stmVehiculo.setInt(5, aparcar.getIdPlaza());
        
        stmVehiculo.executeUpdate();
        bool = true;

        } catch (SQLException e){
          System.out.println(e.getMessage());
          bool = false;
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVehiculo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return bool;
        
    }
    
    
}
