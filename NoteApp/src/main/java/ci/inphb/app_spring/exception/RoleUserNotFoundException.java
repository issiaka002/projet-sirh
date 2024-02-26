package ci.inphb.app_spring.exception;

public class RoleUserNotFoundException extends RuntimeException {
    public RoleUserNotFoundException(String s) {
        super(s);
    }
}
