package parqueo_inteligente.newpackage;


import java.time.Duration;
import java.time.LocalTime;

public class ControlIngreso {
    private Tarifa tarifa;
    private Registro registro;
    private UbicacionParqueo espacio;

    public ControlIngreso(Tarifa tarifa, Registro registro, UbicacionParqueo espacio) {
        this.tarifa = tarifa;
        this.registro = registro;
        this.espacio = espacio;
    }

    public boolean verificarDisponibilidad() {
        return espacio.estaDisponible();
    }

    public boolean asignarUbicacion(Vehiculo vehiculo) {
        if (verificarDisponibilidad()) {
            espacio.asignarVehiculo();
            vehiculo.asignarEspacio(espacio.obtenerUbicacion());
            return true;
        }
        return false;
    }

    public void registrarEntrada(Vehiculo vehiculo, LocalTime horaIngreso) {
        vehiculo.registrarIngreso(horaIngreso);
        registro.guardarIngreso(vehiculo);
    }

    public double registrarSalida(Vehiculo vehiculo, LocalTime horaSalida) {
        vehiculo.registrarSalida(horaSalida);
        registro.guardarSalida(vehiculo);
        espacio.liberar();

        long horas = Duration.between(vehiculo.getHoraIngreso(), vehiculo.getHoraSalida()).toHours();
        long minutos = Duration.between(vehiculo.getHoraIngreso(), vehiculo.getHoraSalida()).toMinutes() % 60;
        if (minutos > 0) horas++;

        double total = tarifa.calcularTarifa(horas);

        // ✅ Generación automática de la factura
        Cliente cliente = vehiculo.getPropietario();  // ← asegúrate de que exista este método
        String nomFactura = "Factura_" + vehiculo.getPlaca();

        ArchiFactura archiFactura = new ArchiFactura();
        archiFactura.crear(nomFactura, cliente, tarifa, horas);

        return total;
    }
}
