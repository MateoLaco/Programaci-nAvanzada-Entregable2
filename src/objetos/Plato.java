package objetos;

public class Plato {
    public final String nombre;
    private int TIEMPO_DE_COCCION_MIN;
    private int TIEMPO_DE_COCCION_MAX;

    public Plato(String nombre, int tiempoDeCoccionMax, int tiempoDeCoccionMin) {
        this.nombre = nombre;
        this.TIEMPO_DE_COCCION_MIN = tiempoDeCoccionMin;
        this.TIEMPO_DE_COCCION_MAX = tiempoDeCoccionMax;
    }

    public void cambiarTiempoDeCoccionMax(int tiempoDeCoccionMax) {
        this.TIEMPO_DE_COCCION_MAX = tiempoDeCoccionMax;
    }

    public void cambiarTiempoDeCoccionMin(int tiempoDeCoccionMin) {
        this.TIEMPO_DE_COCCION_MIN = tiempoDeCoccionMin;
    }
}
