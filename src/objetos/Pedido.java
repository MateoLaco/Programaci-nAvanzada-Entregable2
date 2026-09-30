package objetos;

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
}
