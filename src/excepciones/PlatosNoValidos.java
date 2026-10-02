package excepciones;

public class PlatosNoValidos extends RuntimeException {
    public PlatosNoValidos(String message) {
        super(message);
    }
}
