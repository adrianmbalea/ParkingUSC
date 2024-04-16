package aplicacion;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author grupo2b
 */
public class UsuarioUSC {
    private String dniUsuario;
    private String nombreCompleto;
    private String correoElectronico;
    private String contrasenha;
    private int telefono;
    private float saldo;
    private String rol;
    private Date fechaIngreso;
    private ArrayList<Vehiculo> vehiculos;

    
    public UsuarioUSC(String dniUsuario, String nombreCompleto, String correoElectronico, String contrasenha, int telefono, 
            float saldo, String rol, Date fechaIngreso) {
        this.dniUsuario = dniUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.contrasenha = contrasenha;
        this.telefono = telefono;
        this.saldo = saldo;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
    }

    public UsuarioUSC(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }
    
    // GETTERS
    public String getDniUsuario() {
        return dniUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public int getTelefono() {
        return telefono;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getRol() {
        return rol;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    //SETTERS
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return(
                    "DNI=" + dniUsuario   + "\n"
                + "Nombre=" + nombreCompleto   + "\n"
                + "CorreoElectronico=" + correoElectronico   + "\n"
                + "Contrasenha= ********"  + "\n"
                + "Telefono=" + telefono   + "\n"
                + "Saldo=" + saldo   + "\n"
                + "FechaIngreso=" + fechaIngreso); 
    }
    
    
    
    

}
