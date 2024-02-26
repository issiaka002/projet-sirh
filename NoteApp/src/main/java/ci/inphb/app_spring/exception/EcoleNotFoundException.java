package ci.inphb.app_spring.exception;

public class EcoleNotFoundException extends RuntimeException {
    public EcoleNotFoundException(String msg) {
        super(msg);
    }
}
