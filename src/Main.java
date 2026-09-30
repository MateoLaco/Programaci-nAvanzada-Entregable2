import config.Config;
import restaurante.Restaurante;

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        restaurante.iniciar();

        try {
            Thread.sleep(Config.TIEMPO_SIMULACION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            restaurante.cerrar();
        }
    }
}