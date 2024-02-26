package ci.inphb.app_spring.exception;

public class EnseignantNotFoundException extends RuntimeException {
    public EnseignantNotFoundException(String msg) {
        super(msg);
    }
}
