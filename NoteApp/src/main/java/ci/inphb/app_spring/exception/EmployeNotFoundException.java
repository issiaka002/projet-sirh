package ci.inphb.app_spring.exception;

public class EmployeNotFoundException extends RuntimeException {
    public EmployeNotFoundException(String s) {
        super(s);
    }
}
