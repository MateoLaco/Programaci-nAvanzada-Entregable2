package objetos;

import java.util.concurrent.ThreadLocalRandom;

public class Plato {
    public final String nombre;
    private final int TIEMPO_DE_COCCION_MIN;
    private final int TIEMPO_DE_COCCION_MAX;

    public Plato(String nombre, int tiempoDeCoccionMax, int tiempoDeCoccionMin) {
        this.nombre = nombre;
        this.TIEMPO_DE_COCCION_MIN = tiempoDeCoccionMin;
        this.TIEMPO_DE_COCCION_MAX = tiempoDeCoccionMax;
    }

    public int tiempoDeCoccion() {
        return ThreadLocalRandom.current().nextInt(TIEMPO_DE_COCCION_MIN, TIEMPO_DE_COCCION_MAX + 1);
    }
}
