package objetos;

import config.EstadosTareaMozo;
import lugares.Mesa;

public class TareaMozo {
    private final EstadosTareaMozo estado;
    private final Mesa mesa;

    public TareaMozo(EstadosTareaMozo estado, Mesa mesa){
        this.estado = estado;
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public EstadosTareaMozo getEstado() {
        return estado;
    }
}