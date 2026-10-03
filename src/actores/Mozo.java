package actores;

import config.EstadoPlato;
import config.EstadosTareaMozo;
import lugares.*;
import objetos.Pedido;
import objetos.Plato;
import objetos.TareaMozo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Mozo implements Runnable {

    private final BlockingQueue<TareaMozo> tareasDeMozos;
    private final Random rand;
    private final Cocina cocina;
    private final int TIEMPO_PARA_ANOTAR_PEDIDO_MAX;
    private final int TIEMPO_PARA_ANOTAR_PEDIDO_MIN;

    public Mozo (BlockingQueue<TareaMozo> tareasDeMozos, int tiempo_minimo, int tiempo_maximo, Cocina cocina) {
        this.tareasDeMozos = tareasDeMozos;
        this.rand = new Random();
        this.TIEMPO_PARA_ANOTAR_PEDIDO_MAX =  tiempo_maximo;
        this.TIEMPO_PARA_ANOTAR_PEDIDO_MIN = tiempo_minimo;
        this.cocina = cocina;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                TareaMozo tarea = tareasDeMozos.take();

                if (tarea.getEstado() == EstadosTareaMozo.TOMAR_PEDIDO) {
                    /* Simulación del tiempo de espera para tomar el pedido */
                    Thread.sleep(
                            rand.nextInt(this.TIEMPO_PARA_ANOTAR_PEDIDO_MAX -  this.TIEMPO_PARA_ANOTAR_PEDIDO_MIN + 1)
                            + this.TIEMPO_PARA_ANOTAR_PEDIDO_MIN);
                    /* Se crea un nuevo pedido para enviar a la cocina */
                    Mesa mesa = tarea.getMesa();
                    List<Plato> platos = mesa.obtenerPlatos();
                    for  (Plato plato : platos) {
                        plato.cambiarEstadoPlato(EstadoPlato.CON_MOZO);
                    }
                    Pedido nuevoPedido = new Pedido(mesa, platos);
                    /* Se envía el pedido creado a la cocina */
                    cocina.agregarPedidoPendiente(nuevoPedido);
                } else if (tarea.getEstado() == EstadosTareaMozo.RECOGER_PLATO) {

                } else {

                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
