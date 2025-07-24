package parqueo_inteligente.newpackage;

import java.time.LocalTime;
import java.time.Duration;

public class Vehiculo {
    private String placa;
    private String marca;
    private String color;
    private Cliente propietario;  
    private String tipo;
    private String espacioAsignado;
    private LocalTime horaIngreso;
    private LocalTime horaSalida;

    public Vehiculo(String placa, String marca, String color, Cliente propietario, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.propietario = propietario;
        this.tipo = tipo;
    }

    public void asignarEspacio(String espacio) {
        this.espacioAsignado = espacio;
    }

    public void registrarIngreso(LocalTime hora) {
        this.horaIngreso = hora;
    }

    public void registrarSalida(LocalTime hora) {
        this.horaSalida = hora;
    }

    public String obtenerDuracion() {
        if (horaIngreso != null && horaSalida != null) {
            Duration duracion = Duration.between(horaIngreso, horaSalida);
            long horas = duracion.toHours();
            long minutos = duracion.toMinutes() % 60;
            return String.format("%d horas %d minutos", horas, minutos);
        }
        return "Duración no disponible";
    }

    public String obtenerDatos() {
        return String.format("Vehículo: %s %s (%s)\nTipo: %s\nPropietario: %s\nEspacio: %s",
                marca, color, placa, tipo,
                propietario != null ? propietario.getNombre() : "No asignado",
                espacioAsignado == null ? "No asignado" : espacioAsignado);
    }

    public String getPlaca() {
        return placa;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEspacioAsignado() {
        return espacioAsignado;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }
    public void setPropietario(Cliente propietario) {
    this.propietario = propietario;
}


}
