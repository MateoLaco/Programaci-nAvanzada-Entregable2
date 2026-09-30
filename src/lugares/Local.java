package lugares;

import actores.Cliente;
import config.Config;
import config.EstadosMesas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Local {
    private final List<Mesa> mesas;
    private final Queue<Cliente> clientesEsperando;

    public Local(){
        mesas = new ArrayList<Mesa>(Config.NUMERO_DE_MESAS);
        clientesEsperando = new LinkedList<Cliente>() {
        };
        for (int i = 0; i < Config.NUMERO_DE_MESAS; i++) {
            Mesa mesaNueva = new Mesa(i);
            mesas.add(mesaNueva);
        }
    }

    public Mesa hayMesasLibre(){
        for (Mesa mesa : mesas) {
            if (mesa.getEstadoMesa() == EstadosMesas.LIBRE) {
                return mesa;
            }
        }
        return null;
    }

    public synchronized Mesa esperarMesa(Cliente cliente) throws InterruptedException {

        clientesEsperando.add(cliente);

        while (cliente.getMesaAsignada() == null) {
            Mesa mesaLibre = hayMesasLibre();

            if (clientesEsperando.size() >= Config.PERSONAS_POR_MESA && mesaLibre != null) {
                for (int i = 0; i < Config.PERSONAS_POR_MESA; i++) {
                    Cliente clienteAsignado = clientesEsperando.remove();
                    mesaLibre.agregarCliente(clienteAsignado);
                    clienteAsignado.setMesaAsignada(mesaLibre);
                }
                mesaLibre.setEstadoMesa(EstadosMesas.OCUPADA);
                notifyAll();
            }

            if (cliente.getMesaAsignada() == null) {
                wait();
            }
        }
        return cliente.getMesaAsignada();
    }
}
