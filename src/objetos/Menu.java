package objetos;

import config.Config;

import java.util.List;
import java.util.Random;

public class Menu {
    private final List<Plato> menu;

    public Menu() {
        menu = List.of(
                new Plato("Pizza", 2000, 1000),
                new Plato("Pulpón c/noisette", 3000, 2000),
                new Plato("Gramajo", 1000, 500),
                new Plato("Milanesa c/fritas", 2500, 1500),
                new Plato("Napolitana c/fritas", 2750, 1750)
        );
    }

    public Plato elegirPlato (Random rand) throws InterruptedException {
        return menu.get(rand.nextInt(menu.size()));
    }
}
