package parqueo_inteligente.newpackage;


public class Cliente {
    private String nombre;
    private Vehiculo vehiculo;  
    public Cliente(String nombre, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.vehiculo = vehiculo;
    }

    public String getNombre() { return nombre; }
    public Vehiculo getVehiculo() { return vehiculo; }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String obtenerDatos() {
        return "Cliente: " + nombre +
                (vehiculo != null ? "\n" + vehiculo.obtenerDatos() : "\nNo tiene vehículo asignado.");
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", vehiculo=" + (vehiculo != null ? vehiculo.getPlaca() : "Ninguno") +
                '}';
    }
}
