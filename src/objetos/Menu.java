package objetos;

import config.Config;

import java.util.List;
import java.util.Random;

public class Menu {
    private final List<Plato> menu;

    public Menu() {
        menu = List.of(
                new Plato("Pizza", 1000, 2000),
                new Plato("Pulpón c/noisette", 2000, 3000),
                new Plato("Gramajo", 500, 1000),
                new Plato("Milanesa c/fritas", 1500, 2500),
                new Plato("Napolitana c/fritas", 1750, 2750)
        );
    }

    public Plato elegirPlato (Random rand) throws InterruptedException {
        return menu.get(rand.nextInt(menu.size()));
    }
}
