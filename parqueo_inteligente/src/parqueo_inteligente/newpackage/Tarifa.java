package parqueo_inteligente.newpackage;
public class Tarifa {
    private double tarifaPorHora;

    public Tarifa(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
        
    }

    public double calcularTarifa(long horas) {
        return tarifaPorHora * horas;
    }

    public double getTarifaPorHora() { return tarifaPorHora; }
}