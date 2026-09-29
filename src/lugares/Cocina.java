package lugares;

import objetos.Pedido;

import java.util.concurrent.BlockingQueue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Cocina {
    private final BlockingQueue<Pedido> pedidosPendientes;
    private final BlockingQueue<Pedido> pedidosListos;
    Random rand;

    Cocina() {
        this.pedidosPendientes = new LinkedBlockingQueue<>();
        this.pedidosListos = new LinkedBlockingQueue<>();
        rand = new Random();
    }

    public void agregarPedido(Pedido pedido) throws InterruptedException {
        pedidosPendientes.put(pedido);
    }

    public Pedido tomarPedido() throws InterruptedException {
        return pedidosPendientes.take();
    }

    public void agregarListo(Pedido pedido) throws InterruptedException {
        pedidosListos.put(pedido);
    }

    public  Pedido tomarPedidoListo() throws InterruptedException {
        return pedidosListos.take();
    }
}
