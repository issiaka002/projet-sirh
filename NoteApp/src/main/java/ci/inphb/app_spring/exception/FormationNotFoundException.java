package ci.inphb.app_spring.exception;

public class FormationNotFoundException extends RuntimeException {
    public FormationNotFoundException(String message) {
        super(message);
    }
}
