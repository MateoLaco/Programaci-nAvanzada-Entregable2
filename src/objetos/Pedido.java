package objetos;

import config.EstadoPlato;
import excepciones.PlatoNoValido;
import lugares.Mesa;

import java.util.List;

public class Pedido {
    private final Mesa mesa;
    private final List<Plato> platos;

    public Pedido(Mesa mesa, List<Plato> platos) {
        this.mesa = mesa;
        this.platos = List.copyOf(platos);
    }

    /* Pedidos */
    public List<Plato> obtenerPlatosDePedido() {
        return this.platos;
    }

    /* Mesa */
    public Mesa getMesa() {
        return this.mesa;
    }

    private boolean pedidoTerminado(){
        for (Plato plato : this.platos){
            if (plato.getEstadoPlato() != EstadoPlato.PRONTO){
                return false;
            }
        }
        return true;
    }

    public synchronized boolean registrarPlatoTerminado(Plato plato) throws PlatoNoValido {
        if (!this.platos.contains(plato)){
            throw new PlatoNoValido("Este plato no pertenece al pedido,");
        }
        if (plato.getEstadoPlato() != EstadoPlato.COCINANDO){
            throw new PlatoNoValido("Plato no es válido");
        }
        plato.cambiarEstadoPlato(EstadoPlato.PRONTO);
        return this.pedidoTerminado();
    }
}
