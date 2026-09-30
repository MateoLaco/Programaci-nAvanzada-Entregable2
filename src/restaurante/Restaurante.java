package restaurante;

import lugares.*;

import java.util.concurrent.ExecutorService;

public class Restaurante {

    private final Local local;
    private final Cocina cocina;
    private final Caja caja;

    private ExecutorService cocineros;
    private ExecutorService mozos;
    private ExecutorService cajeros;

    public Restaurante() {
        this.local = new Local();
        this.cocina = new Cocina();
        this.caja = new Caja();
    }

    public void iniciar(){

    }

    public void cerrar(){}
}
