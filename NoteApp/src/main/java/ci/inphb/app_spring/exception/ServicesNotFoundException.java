package ci.inphb.app_spring.exception;

public class ServicesNotFoundException extends RuntimeException {
    public ServicesNotFoundException(String s) {
        super(s);
    }
}
