package lugares;

import objetos.Pedido;
import objetos.Plato;

import java.util.concurrent.BlockingQueue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Cocina {
    private final BlockingQueue<Pedido> pedidosPendientes;
    private final BlockingQueue<Pedido> pedidosListos;

    public Cocina() {
        this.pedidosPendientes = new LinkedBlockingQueue<>();
        this.pedidosListos = new LinkedBlockingQueue<>();
    }

    public void agregarPedidoPendiente(Pedido pedido) throws InterruptedException {
        pedidosPendientes.put(pedido);
    }

    public Plato tomarPlatoPendiente() throws InterruptedException {
        this
    }

    public void agregarPedidoListo(Pedido pedido) throws InterruptedException {
        pedidosListos.put(pedido);
    }

    public  Pedido tomarPedidoListo() throws InterruptedException {
        return pedidosListos.take();
    }
}
