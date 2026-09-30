package objetos;

import lugares.Mesa;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Mesa mesa;
    List<Plato> platos;

    public Pedido(Mesa mesa, ArrayList<Plato> platos) {
        this.mesa = mesa;
        this.platos = platos;
    }
}
