package actores;

import config.Config;
import lugares.*;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

import objetos.Menu;
import objetos.Pedido;
import objetos.Plato;

public class Cliente implements Runnable{
    private int idCliente;
    private final Local local;
    private final Menu menu;
    private final Caja caja;
    private volatile Mesa mesaAsignada; //como mesaAsignada la escribe un hilo (el que hace el esperarMesa que arma el grupo) y la leen otros se narca como volatile
    private volatile Plato plato;
    private final Random rand;

    public Cliente(int idCliente, Local local, Menu menu, Caja caja) { //constructor de cliente public asi Restaurante puede crear clientes
        this.idCliente = idCliente;
        this.local = local;
        this.menu = menu;
        this.caja = caja;
        this.rand = new Random();
    }

    public Mesa getMesaAsignada() {
        return mesaAsignada;
    }

    public void setMesaAsignada(Mesa mesaAsignada) {
        this.mesaAsignada = mesaAsignada;
    }

    public Plato getPlato() {
        return plato;
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
        try{
            /* Ejecuta código de esperar a una mesa y la asigna al cliente */
            /* Esto espera a que se llena la mesa y luego continúa el código */
            this.mesaAsignada = local.esperarMesa(this);
            /* Espera un tiempo aleatorio dentro del rango de tiempos de espera */
            /* Esto simula el tiempo de espera para elegir un plato del menú */
            Thread.sleep(rand.nextInt(Config.TIEMPO_PARA_ELEGIR_MAX - Config.TIEMPO_PARA_ELEGIR_MIN + 1) + Config.TIEMPO_PARA_ELEGIR_MIN);
            /* Ejecuta la elección de item del menú */
            /* Esto solo devuelve el plato que se eligió */
            this.plato = menu.elegirPlato(rand);
            /* Ejecuta la espera del mozo */
            this.mesaAsignada.esperarMozo();
        } catch (InterruptedException e){
            System.out.println("Error al muestrar la mesa asignada");
        } catch (BrokenBarrierException e) {
            System.out.println("Error al elegir menu");
        }
    }
}
