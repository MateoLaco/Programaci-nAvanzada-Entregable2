package lugares;

import actores.Cliente;
import config.Config;
import config.EstadosMesas;
import config.EstadosTareaMozo;
import objetos.Plato;
import objetos.TareaMozo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Mesa{
    private final int idMesa;
    private volatile EstadosMesas estadoMesa;
    private final BlockingQueue<TareaMozo> tareasDeMozos;
    private final CyclicBarrier barreraMenu;
    private final CyclicBarrier barreraComer;
    private final List<Cliente> clientes;

    public Mesa(int idMesa, BlockingQueue<TareaMozo> tareasDeMozos) {
        this.idMesa = idMesa;
        this.estadoMesa = EstadosMesas.LIBRE;
        this.tareasDeMozos = tareasDeMozos;
        this.barreraMenu = new CyclicBarrier(
                Config.PERSONAS_POR_MESA,
                this::pedirMozo
        );
        this.barreraComer = new CyclicBarrier(
                Config.PERSONAS_POR_MESA,
                () -> {
                    // Acá supongo que iría lo de ir a comer
                }
        );
        this.clientes = Collections.synchronizedList(new ArrayList<>(Config.PERSONAS_POR_MESA)); //clientes como lista sincronizada
    }

    public int getIdMesa() { return idMesa; }
    public EstadosMesas getEstadoMesa() { return estadoMesa; }
    public void setEstadoMesa(EstadosMesas estadoMesa) { this.estadoMesa = estadoMesa; } //todos en public asi los mozos lo puede ver
    public List<Cliente> getClientes() { return clientes; }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Plato> obtenerPlatos() {
        List<Plato> platos = new ArrayList<>(Config.PERSONAS_POR_MESA);
        for(Cliente cliente : this.clientes) {
            platos.add(cliente.getPlato());
        }
        return platos;
    }

    /* Manejo de barreras cíclicas */
    public void esperarMozo() throws InterruptedException, BrokenBarrierException {
        barreraMenu.await();
    }

     public void esperarComer() throws InterruptedException, BrokenBarrierException {
        barreraComer.await();
    }


     public void vaciar() {
        clientes.clear();
        this.estadoMesa = EstadosMesas.LIBRE;
        // Avisar al local que se liberó una mesa
    }

    public void pedirMozo(){
        this.estadoMesa = EstadosMesas.ESPERANDO_MOZO;

        try {
            this.tareasDeMozos.put(new TareaMozo(EstadosTareaMozo.TOMAR_PEDIDO, this));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
