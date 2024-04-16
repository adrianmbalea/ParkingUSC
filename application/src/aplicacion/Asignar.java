/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import java.util.Date;

/**
 *
 * @author grupo2b
 */
public class Asignar {
    
    private Date fechaInicio;
    private Date fechaFin;
    private UsuarioUSC usuario;
    private Campus campus;
    private Centro centro;
    private int idPlaza;

    public Asignar(Date fechaInicio, Date fechaFin, UsuarioUSC usuario, Campus campus, Centro centro, int idPlaza) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.campus = campus;
        this.centro = centro;
        this.idPlaza = idPlaza;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
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

    
    
    
    
    
}
