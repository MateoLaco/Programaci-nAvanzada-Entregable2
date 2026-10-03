package objetos;

import config.EstadoPlato;

import java.util.concurrent.ThreadLocalRandom;

public class Plato {
    private final String nombre;
    private final int precio;
    private EstadoPlato estadoPlato;
    private final int TIEMPO_DE_COCCION_MIN;
    private final int TIEMPO_DE_COCCION_MAX;

    public Plato(String nombre, int tiempoDeCoccionMin, int tiempoDeCoccionMax, int precio) {
        this.nombre = nombre;
        this.TIEMPO_DE_COCCION_MIN = tiempoDeCoccionMin;
        this.TIEMPO_DE_COCCION_MAX = tiempoDeCoccionMax;
        this.precio = precio;
        this.estadoPlato = EstadoPlato.PEDIDO;
    }

    public Plato(Plato platoBase){
        this.nombre = platoBase.nombre;
        this.TIEMPO_DE_COCCION_MIN = platoBase.TIEMPO_DE_COCCION_MIN;
        this.TIEMPO_DE_COCCION_MAX = platoBase.TIEMPO_DE_COCCION_MAX;
        this.precio = platoBase.precio;
        this.estadoPlato = platoBase.estadoPlato;
    }

    public EstadoPlato getEstadoPlato() {
        return this.estadoPlato;
    }

    public void cambiarEstadoPlato(EstadoPlato estadoPlato){
        this.estadoPlato = estadoPlato;
    }
    public int tiempoDeCoccion() {
        return ThreadLocalRandom.current().nextInt(TIEMPO_DE_COCCION_MIN, TIEMPO_DE_COCCION_MAX + 1);
    }
}
