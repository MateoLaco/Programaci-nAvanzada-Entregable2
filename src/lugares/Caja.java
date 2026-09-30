package lugares;

import actores.Cliente;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Caja {
    private BlockingQueue<Cliente> colaPago;

    public Caja(){
        colaPago = new LinkedBlockingQueue<>();
    }

    public void agregarCliente(Cliente cliente) throws InterruptedException{
        colaPago.put(cliente);
    }

    public Cliente cobrar() throws InterruptedException{
        return colaPago.take();
    }
}
