package parqueo_inteligente.newpackage;
public class Parqueo {
    private String id;
    private int espaciosOcupados;
    private int totalEspacios;
    private boolean barrera;

    public Parqueo(String id, int totalEspacios) {
        this.id = id;
        this.totalEspacios = totalEspacios;
        this.espaciosOcupados = 0;
        this.barrera = false;
    }

    public boolean estaDisponible() {
        return espaciosOcupados < totalEspacios;
    }

    public void ocuparEspacio() {
        if (estaDisponible()) espaciosOcupados++;
    }

    public void liberarEspacio() {
        if (espaciosOcupados > 0) espaciosOcupados--;
    }

    public void abrirBarrera() { barrera = true; }
    public void cerrarBarrera() { barrera = false; }
    public int getEspaciosOcupados() { return espaciosOcupados; }
    public int getTotalEspacios() { return totalEspacios; }
}
