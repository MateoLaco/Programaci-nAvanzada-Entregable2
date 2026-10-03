package objetos;

import config.EstadosTareaMozo;
import lugares.Mesa;

public class TareaMozo {
    private final EstadosTareaMozo estado;
    private final Mesa mesa;
    private final Pedido pedido;

    public TareaMozo(EstadosTareaMozo estado,Mesa mesa, Pedido pedido){
        this.estado = estado;
        if (this.estado == EstadosTareaMozo.TOMAR_PEDIDO){
            this.mesa = mesa;
            this.pedido = null;
        } else {
            this.mesa = mesa;
            this.pedido = pedido;
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public EstadosTareaMozo getEstado() {
        return estado;
    }
}