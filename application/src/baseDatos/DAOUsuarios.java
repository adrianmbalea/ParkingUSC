/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.*;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author grupo2b
 */
public class DAOUsuarios extends AbstractDAO {

   public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

   // Valida un usuario con sus credenciales
public UsuarioUSC validarUsuario(String correoUsuario, String clave){
        UsuarioUSC resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;
        
        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("select m.dni, m.nombrecompleto, m.correoelectronico, m.contrasenha, m.telefono, " +
" m.saldo, m.rol, m.fechaingreso, sum(v.numeroinfracciones) as sumaInfracciones " +
"from miembrosusc m, vehiculos v " +
"where m.dni = v.dnimiembrousc " +
" and m.correoelectronico =  ? " +
" and contrasenha = hash_password(?) " +
" group by m.dni, m.nombrecompleto, m.correoelectronico, m.contrasenha, m.telefono, " +
" m.saldo, m.rol, m.fechaingreso");
        stmUsuario.setString(1, correoUsuario);
        stmUsuario.setString(2, clave);
        rsUsuario=stmUsuario.executeQuery();
        if(rsUsuario.next()){
            String rol;
            if(rsUsuario.getInt("sumaInfracciones") >= 5){
            rol = "vetado";
        }else{
                rol =  rsUsuario.getString("rol");
           }
           resultado = new UsuarioUSC(rsUsuario.getString("dni"), rsUsuario.getString("nombrecompleto"),
                                      rsUsuario.getString("correoelectronico"), rsUsuario.getString("contrasenha"),
                                      rsUsuario.getInt("telefono"),  rsUsuario.getFloat("saldo"), 
                                      rol , rsUsuario.getDate("fechaingreso"));
           
        } 
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

// Devuelve los datos de un usuario a partir de su DNI
public UsuarioUSC getUsuario(String DNIUsuario){
        UsuarioUSC resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;
        
        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("select * " +
"from miembrosusc m  " +
"where m.dni like ? ");
        stmUsuario.setString(1, DNIUsuario);
        rsUsuario=stmUsuario.executeQuery();
        if(rsUsuario.next()){
            String rol;
           resultado = new UsuarioUSC(rsUsuario.getString("dni"), rsUsuario.getString("nombrecompleto"),
                                      rsUsuario.getString("correoelectronico"), rsUsuario.getString("contrasenha"),
                                      rsUsuario.getInt("telefono"),  rsUsuario.getFloat("saldo"), 
                                      rsUsuario.getString("rol") , rsUsuario.getDate("fechaingreso"));
           
        } 
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    // Retira un vehiculo de vehiculos aparcados
    public boolean cambiarSaldo(UsuarioUSC usuario, float saldo){
        
        Boolean bool = false;
        Connection con;
        PreparedStatement stmVehiculo=null;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("update miembrosusc set saldo =  ? where dni like ?  ;");
        stmVehiculo.setFloat(1, saldo);
        stmVehiculo.setString(2, usuario.getDniUsuario());
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
        return vehiculosUsuario;
        
    }
    
    // Devuelve los datos de reservar de todas las reservas del usuario
    public ArrayList<Reservar> reservasTotales(UsuarioUSC usuario){
        
         ArrayList<Reservar> reservasTotales = new ArrayList<>();
        Connection con;
        PreparedStatement stmVehiculo=null;
        ResultSet rsVehiculos;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("select r.fechaInicio, r.fechaFin, r.preciohora, p.campus, p.centro, r.idplaza  " +
"from reservar r " +
"left join plazasPrivadas pp on r.campusParking = pp.campusParking and " +
"r.centroParking = pp.centroParking and r.idPlaza = pp.id " +
"left join plazasPublicas pb on r.campusParking = pb.campusParking and " +
"r.centroParking = pb.centroParking and r.idPlaza = pb.id " +
"inner join parkings p on p.campus = coalesce(pp.campusParking, pb.campusParking) " +
"and p.centro = coalesce(pp.centroParking, pb.centroParking) " +
"where r.dniMiembroUSC like ? " +
"order by r.fechaInicio asc; ");
        stmVehiculo.setString(1, usuario.getDniUsuario());
        rsVehiculos=stmVehiculo.executeQuery();
        while(rsVehiculos.next())
        {
             reservasTotales.add(new Reservar(rsVehiculos.getTimestamp("fechainicio"), rsVehiculos.getTimestamp("fechafin"), rsVehiculos.getInt("preciohora"), usuario,
                     new Campus(rsVehiculos.getString("campus")), new Centro( rsVehiculos.getString("centro")), rsVehiculos.getInt("idplaza") ));
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmVehiculo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return reservasTotales;
        
    }

        // Cancela una reserva devolviendo al usuario un porcentaje del coste
    public boolean cancelarReserva(Reservar reserva){
        
        Boolean bool = false;
        Connection con;
        PreparedStatement stmVehiculo=null;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("begin transaction; " +
"	-- Actualizamos fechaFin ala fecha en la que se ejecuta la transaccion, de esta forma indicamos que la plaza queda libre  " +
"	update reservar set fechaFin = current_date  " +
"		where fechaInicio = ?   " +
"		and dnimiembrousc like ?   " +
"		and campusparking like ?  " +
"		and centroparking like ?   " +
"		and idplaza = ?  " +
"commit transaction;");
        
        // Introducir correctamente el tipo de dato Timestamp
        stmVehiculo.setTimestamp(1, reserva.getFechaInicio() );  stmVehiculo.setString(2, reserva.getUsuario().getDniUsuario());
        stmVehiculo.setString(3, reserva.getCampus().getNombre()); stmVehiculo.setString(4, reserva.getCentro().getNombre());
        stmVehiculo.setInt(5, reserva.getIdPlaza());
        
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
   
    public boolean realizarReserva(Reservar reserva){
        
        Boolean bool = false;
        Connection con;
        PreparedStatement stmVehiculo=null;

        con=super.getConexion();

        try {
        stmVehiculo =con.prepareStatement("begin transaction;\n" +
"\n" +
"	insert into reservar (fechaInicio, fechaFin, precioHora, dniMiembroUSC, campusParking, centroParking, idPlaza)\n" +
"	values (?, ?, ?, ?, ?, ?, ?);\n" +
"\n" +
"commit transaction;");
        stmVehiculo.setTimestamp(1, reserva.getFechaInicio());
        stmVehiculo.setTimestamp(2, reserva.getFechaFin());
        stmVehiculo.setFloat(3, reserva.getPrecioHora());
        stmVehiculo.setString(4, reserva.getUsuario().getDniUsuario());
        stmVehiculo.setString(5, reserva.getCampus().getNombre());
        stmVehiculo.setString(6, reserva.getCentro().getNombre());
        stmVehiculo.setInt(7, reserva.getIdPlaza());
        
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
