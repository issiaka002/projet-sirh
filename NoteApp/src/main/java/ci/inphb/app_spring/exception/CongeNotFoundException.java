package ci.inphb.app_spring.exception;

public class CongeNotFoundException extends RuntimeException {
    public CongeNotFoundException(String msg) {
        super(msg);
    }
}
