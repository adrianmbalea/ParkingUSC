/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import java.sql.Timestamp;

/**
 *
 * @author grupo2b
 */
public class Aparcar {
    
    private Timestamp fechaEntrada;
    private Timestamp fechaSalida;
    private float precioHora;
    private Vehiculo vehiculo;
    private Campus campus;
    private Centro centro;
    private int idPlaza;

    public Aparcar(Timestamp fechaEntrada, Timestamp fechaSalida, float precioHora, Vehiculo vehiculo, Campus campus, Centro centro, int idPlaza) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioHora = precioHora;
        this.vehiculo = vehiculo;
        this.campus = campus;
        this.centro = centro;
        this.idPlaza = idPlaza;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Campus getCampus() {
        return campus;
    }

    public Centro getCentro() {
        return centro;
    }

    public int getIdPlaza() {
        return idPlaza;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    
}
