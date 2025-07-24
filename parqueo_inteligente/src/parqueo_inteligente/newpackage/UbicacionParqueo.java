package parqueo_inteligente.newpackage;
public class UbicacionParqueo {
    private String planta;
    private String carril;
    private String casilla;
    private boolean ocupado;

    public UbicacionParqueo(String planta, String carril, String casilla) {
        this.planta = planta;
        this.carril = carril;
        this.casilla = casilla;
        this.ocupado = false;
    }

    public boolean estaDisponible() { return !ocupado; }
    public void asignarVehiculo() { ocupado = true; }
    public void liberar() { ocupado = false; }
    public String obtenerUbicacion() {
        return String.format("%s, %s, %s", planta, carril, casilla);
    }
}