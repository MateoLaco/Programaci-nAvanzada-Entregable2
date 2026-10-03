package lugares;

import config.EstadoPlato;
import config.EstadosTareaMozo;
import excepciones.PlatoNoValido;
import objetos.Pedido;
import objetos.Plato;
import objetos.TareaCocina;
import objetos.TareaMozo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cocina {
    private final BlockingQueue<TareaCocina> tareasCocina;
    private final BlockingQueue<TareaMozo> tareasDeMozos;

    public Cocina(BlockingQueue<TareaMozo> tareasDeMozos) {
        this.tareasCocina = new LinkedBlockingQueue<>();
        this.tareasDeMozos = tareasDeMozos;
    }

    public synchronized void agregarPedidoPendiente(Pedido pedido) throws InterruptedException {
        for (Plato plato : pedido.obtenerPlatosDePedido()){
            plato.cambiarEstadoPlato(EstadoPlato.PENDIENTE);
            tareasCocina.put(new TareaCocina(pedido, plato));
        }
    }

    public TareaCocina tomarPlatoPendiente() throws InterruptedException, PlatoNoValido {
        TareaCocina tareaCocina = this.tareasCocina.take();
        Plato plato = tareaCocina.getPlato();
        if (plato.getEstadoPlato() != EstadoPlato.PENDIENTE){
            throw new PlatoNoValido("El plato no puede estar no pendiente");
        }
        plato.cambiarEstadoPlato(EstadoPlato.COCINANDO);
        return tareaCocina;
    }

    public void registrarPlatoPronto(TareaCocina tarea) throws InterruptedException {
        Pedido pedido = tarea.getPedido();
        boolean esUltimoPlato = pedido.registrarPlatoTerminado(tarea.getPlato());
        if (esUltimoPlato) {
            this.tareasDeMozos.put(new TareaMozo(EstadosTareaMozo.RECOGER_PLATO, pedido.getMesa(), pedido));
        }
    }
}
