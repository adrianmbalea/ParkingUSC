package aplicacion;

/**
 *
 * @author grupo2b
 */
public class Parking {
    private Campus campus;
    private Centro centro;
    private int capacidad;
    private int maximoPrivadas;

    public Parking(Campus campus, Centro centro, int capacidad, int maximoPrivadas) {
        this.campus = campus;
        this.centro = centro;
        this.capacidad = capacidad;
        this.maximoPrivadas = maximoPrivadas;
    }

    // GETTERS
    public Campus getCampus() {
        return campus;
    }

    public Centro getCentro() {
        return centro;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getMaximoPrivadas() {
        return maximoPrivadas;
    }
    
    // SETTERS
    public void setMaximoPrivadas(int maximoPrivadas) {
        this.maximoPrivadas = maximoPrivadas;
    }
    
}
