/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Aparcar;
import aplicacion.Centro;
import aplicacion.UsuarioUSC;
import aplicacion.Campus;
import aplicacion.Parking;

import aplicacion.Reservar;
import aplicacion.Vehiculo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author grupo2b
 */
public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    // DAOs
    private DAOUsuarios daoUsuarios;
    private DAOVehiculos daoVehiculos;
    private DAOParkings daoParkings;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);


            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoVehiculos = new DAOVehiculos(conexion, fa);
            daoParkings = new DAOParkings(conexion, fa);

         

        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }
        
        
        
    }
    
    // Devuelve los vehiculos de un usuario determinado
    public ArrayList<Vehiculo> vehiculosUsuario(UsuarioUSC usuario){
        return daoVehiculos.vehiculosUsuario(usuario);
    }
    
    // Devuelve los datos de aparcar de los vehiculos de un usuario que están aparcados
    public ArrayList<Aparcar> vehiculosAparcados(UsuarioUSC usuario){
        return daoVehiculos.vehiculosAparcados(usuario);
    }  
    // Retira un vehiculo de vehiculos aparcados
    public boolean retirarVehiculoAparcado(Aparcar aparcar){
        return daoVehiculos.retirarVehiculoAparcado(aparcar);
    }
    
        // Retira un vehiculo de vehiculos aparcados
    public boolean cambiarSaldo(UsuarioUSC usuario, float saldo){
        return daoUsuarios.cambiarSaldo(usuario, saldo);
    }
    
     // Anhade un vehiculo de un usuario
    public boolean anhadirVehiculo(UsuarioUSC usuario, Vehiculo vehiculo){
        return daoVehiculos.anhadirVehiculo(usuario, vehiculo);
    }
    
        // Devuelve los datos de reservar de todas las reservas del usuario
    public ArrayList<Reservar> reservasTotales(UsuarioUSC usuario){
        return daoUsuarios.reservasTotales(usuario);
    }
    
    // Valida los datos de un usuario y devuelve su informacion
    public UsuarioUSC validarUsuario(String correoUsuario, String clave){
        return daoUsuarios.validarUsuario(correoUsuario, clave);
    }
    
     // Cancela una reserva devolviendo al usuario un porcentaje del coste
    public boolean cancelarReserva(Reservar reserva){
        return daoUsuarios.cancelarReserva(reserva);
    }
    
            // Anhade una infraccion a un vehiculo
    public boolean anhadirInfraccion(Vehiculo vehiculo){
        return daoVehiculos.anhadirInfraccion(vehiculo);
    }
    
    // Devuelve los datos de un usuario a partir de su DNI
public UsuarioUSC getUsuario(String DNIUsuario){
    return daoUsuarios.getUsuario(DNIUsuario);
}

        // Anhade un vehiculo a un parking
    public boolean aparcarVehiculo(Aparcar aparcar){
        return daoVehiculos.aparcarVehiculo(aparcar);
    }
       
    public ArrayList<Campus> listarCampus(){
        return daoParkings.listarCampus();
    }
    
    public ArrayList<Centro> listarCentros(String campus){
        return daoParkings.listarCentros(campus);
    }
    
    public String verPlaza(Integer numPlaza, Parking parking, Timestamp fechaEntrada, Timestamp fechaSalida){
        return daoParkings.verPlaza(numPlaza, parking, fechaEntrada, fechaSalida);
    }
    
    public Parking getParking(Campus campus, Centro centro){
         return daoParkings.getParking(campus, centro);
    }
     // funcion que recibe un numero de plaza y un parking y devuelve el tipo de plaza (publica o privada)
    public String verTipoPlaza(Integer numPlaza, Parking parking){
        return daoParkings.verTipoPlaza(numPlaza, parking);
    }

    public boolean realizarReserva(Reservar reserva){
        return daoUsuarios.realizarReserva(reserva);
    }
    
}
