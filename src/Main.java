import config.Config;
import restaurante.Restaurante;

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        restaurante.iniciar();

        try {
            Thread.sleep(Config.TIEMPO_SIMULACION * 1000L); //Ahora la simulacion dura 60 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            restaurante.cerrar();
        }
    }
}