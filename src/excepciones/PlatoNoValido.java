package excepciones;

public class PlatoNoValido extends RuntimeException {
    public PlatoNoValido(String message) {
        super(message);
    }
}
