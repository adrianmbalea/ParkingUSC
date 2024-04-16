package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author grupo2b
 */
public class Vehiculo {

    private String matricula;
    private String tipo;
    private String marca;
    private String modelo;
    private int numeroInfracciones;
    

    public Vehiculo (String matricula, String tipo, String marca, String modelo, int numeroInfracciones){
        this.matricula = matricula;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroInfracciones = 0;
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    
    // GETTERS
    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getNumeroInfracciones() {
        return numeroInfracciones;
    }
    
    
    // SETTERS
    public void setNumeroInfracciones(int numeroInfracciones) {
        this.numeroInfracciones = numeroInfracciones;
    }
    
    

    @Override
    public String toString() {
        return ("Matricula=" + matricula + "\n"
                + "Tipo=" + tipo + "\n"
                + "Marca=" + marca + "\n"
                + "Modelo=" + modelo + "\n"
                + "NumeroInfracciones=" + numeroInfracciones);
    }
    
    
    
}
