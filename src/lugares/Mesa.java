package lugares;

import actores.Cliente;
import config.Config;
import config.EstadosMesas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Mesa {
    private final int idMesa;
    private volatile EstadosMesas estadoMesa;
    private final CyclicBarrier barreraMenu;
    private final CyclicBarrier barreraComer;
    private final List<Cliente> clientes;

    public Mesa(int idMesa) {
        this.idMesa = idMesa;
        this.estadoMesa = EstadosMesas.LIBRE;
        this.barreraMenu = new CyclicBarrier(Config.PERSONAS_POR_MESA);
        this.barreraComer = new CyclicBarrier(Config.PERSONAS_POR_MESA);
        this.clientes = Collections.synchronizedList(new ArrayList<>(Config.PERSONAS_POR_MESA)); //clientes como lista sincronizada
    }

    public int getIdMesa() { return idMesa; }
    public EstadosMesas getEstadoMesa() { return estadoMesa; }
    public void setEstadoMesa(EstadosMesas estadoMesa) { this.estadoMesa = estadoMesa; } //todos en public asi los mozos lo puede ver

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Mesa esperarMenu(Cliente cliente) throws InterruptedException, BrokenBarrierException {
        barreraMenu.await();
        return this;
    }

     public void esperarComer() throws InterruptedException, BrokenBarrierException {
        barreraComer.await();
    }

     public void vaciar() {
        clientes.clear();
    }
}
