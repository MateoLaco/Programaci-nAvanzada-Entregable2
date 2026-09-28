package lugares;

import config.Config;
import objetos.Pedido;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class Cocina {
    final private ExecutorService executor;
    int TCmin;
    int TCmax;
    Random rand;

    Cocina() {
        executor = Executors.newFixedThreadPool(Config.C);

        rand = new Random();
    }

    public void cocinarPlato(BlockingQueue<Pedido> colaPlatos, Pedido pedido) {
        try {
            Thread.sleep(rand.nextInt(TCmax - TCmin) + TCmin);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
