package actores;

import lugares.Mesa;

public class Cliente implements Runnable{
    private int idCliente;
    private Mesa mesaAsignada;

    Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Mesa getMesaAsignada() {
        return mesaAsignada;
    }

    public void setMesaAsignada(Mesa mesaAsignada) {
        this.mesaAsignada = mesaAsignada;
    }

    @Override
    public void run(){
        /*

        1. Ingresan al restaurante.
        2. Se agrupan una cantidad P de clientes para poder sentarse en una mesa libre. Los P
           clientes se sientan en la misma mesa. Si son menos de P clientes se quedan
           esperando.
        3. Seleccionan qué comer del menú. Luego de que los P clientes seleccionan el menú
           llaman a un mozo. Demora un tiempo aleatorio entre TMmin y TMmax seleccionar el
           menú. El menú se selecciona de forma aleatorio entre una lista de menús
           disponibles.
        4. Esperan que venga un mozo.
        5. Cuando el mozo llega hacen el pedido.
        6. Esperan que el mozo traiga la comida para los P clientes.
        7. Luego que todos los clientes de la mesa están servidos comen. Demoran un tiempo
           aleatorio entre TQmin y TQmax en comer.
        8. Cada uno de forma individual, a medida que terminan de comer, van a la o las cajas
           a pagar.
        9. Se retiran de forma individual del restaurante. Cuando se van los P clientes del
           restaurante la mesa queda libre.

         */
    }
}
