package ci.inphb.app_spring.exception;

public class DirectionNotFoundException extends RuntimeException {
    public DirectionNotFoundException(String s) {
        super(s);
    }
}
