package parqueo_inteligente.newpackage;
import java.util.ArrayList;
import java.util.List;

public class Registro {
    private List<Vehiculo> ingresos;
    private List<Vehiculo> salidas;

    public Registro() {
        ingresos = new ArrayList<>();
        salidas = new ArrayList<>();
    }

    public void guardarIngreso(Vehiculo vehiculo) {
        ingresos.add(vehiculo);
        System.out.println("Ingreso registrado: " + vehiculo.getPlaca());
    }

    public void guardarSalida(Vehiculo vehiculo) {
        salidas.add(vehiculo);
        System.out.println("Salida registrada: " + vehiculo.getPlaca());
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo v : ingresos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
}