package objetos;

import config.EstadoPlato;
import excepciones.PlatosNoValidos;
import lugares.Mesa;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final Mesa mesa;
    private final List<Plato> platos;

    public Pedido(Mesa mesa, List<Plato> platos) {
        this.mesa = mesa;
        this.platos = platos;
    }

    public synchronized Plato obtenerPlatoDePedido() throws PlatosNoValidos {
        for  (Plato plato : platos) {
            if (plato.estadoPlato == EstadoPlato.PENDIENTE){
                plato.estadoPlato = EstadoPlato.COCINANDO;
                return plato;
            }
        }
        throw new PlatosNoValidos("Algo no funcionó en los platos");
    }
}
