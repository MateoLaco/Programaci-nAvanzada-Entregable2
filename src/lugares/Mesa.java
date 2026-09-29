package lugares;

import config.Config;

import java.util.concurrent.CyclicBarrier;


public class Mesa {
    private int idMesa;
    private CyclicBarrier barreraMenu;
    private CyclicBarrier barreraComer;

    Mesa(int idMesa) {
        this.idMesa = idMesa;
        this.barreraMenu = new CyclicBarrier(Config.P);
        this.barreraComer = new CyclicBarrier(Config.P);
    }
}
