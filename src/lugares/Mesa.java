package lugares;

import actores.Cliente;
import config.Config;
import config.EstadosMesas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Mesa {
    private int idMesa;
    private EstadosMesas estadoMesa;
    private CyclicBarrier barreraMenu;
    private CyclicBarrier barreraComer;
    private List<Cliente> clientes;

    public Mesa(int idMesa) {
        this.idMesa = idMesa;
        this.estadoMesa = EstadosMesas.LIBRE;
        this.barreraMenu = new CyclicBarrier(Config.PERSONAS_POR_MESA);
        this.barreraComer = new CyclicBarrier(Config.PERSONAS_POR_MESA);
        this.clientes = new ArrayList<>(Config.PERSONAS_POR_MESA);
    }

    protected EstadosMesas getEstadoMesa() {
        return estadoMesa;
    }

    protected void setEstadoMesa(EstadosMesas estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Mesa esperarMenu(Cliente cliente) throws InterruptedException, BrokenBarrierException {
        this.clientes.add(cliente);
        barreraMenu.await();
        return this;
    }
}
