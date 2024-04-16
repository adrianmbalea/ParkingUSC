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
public class Reservar {
    
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private float precioHora;
    private UsuarioUSC usuario;
    private Campus campus;
    private Centro centro;
    private int idPlaza;

    public Reservar(Timestamp fechaInicio, Timestamp fechaFin, float precioHora, UsuarioUSC usuario, Campus campus, Centro centro, int idPlaza) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioHora = precioHora;
        this.usuario = usuario;
        this.campus = campus;
        this.centro = centro;
        this.idPlaza = idPlaza;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public UsuarioUSC getUsuario() {
        return usuario;
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

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    
    
    
    
}
