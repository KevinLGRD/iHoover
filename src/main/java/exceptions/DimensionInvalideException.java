package exceptions;

public class DimensionInvalideException extends Exception {
    public DimensionInvalideException() {
        super("Les dimensions doivent être strictement positives");
    }
}
