package restaurante;

import lugares.*;
import objetos.TareaMozo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurante {

    private final Local local;
    private final Cocina cocina;
    private final Caja caja;

    private final BlockingQueue<TareaMozo> tareasDeMozos;

    private ExecutorService cocineros;
    private ExecutorService mozos;
    private ExecutorService cajeros;

    public Restaurante() {
        this.cocina = new Cocina();
        this.caja = new Caja();
        this.tareasDeMozos = new LinkedBlockingQueue<TareaMozo>();
        this.local = new Local(tareasDeMozos);
    }

    public void iniciar(){
    }

    public void cerrar(){}
}
