package lugares;

import config.Config;

import java.util.concurrent.CyclicBarrier;


public class Mesa {
    private int idMesa;
    private CyclicBarrier barrera;

    Mesa(int idMesa) {
        this.idMesa = idMesa;
        this.barrera = new CyclicBarrier(Config.P);
    }
}
