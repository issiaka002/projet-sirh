package ci.inphb.app_spring.web.advice;

import ci.inphb.app_spring.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class ControllerAdvic {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeNotFoundException.class)
    public @ResponseBody Map<String, String> handleException(EmployeNotFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EnseignantNotFoundException.class)
    public @ResponseBody Map<String, String> handleException(EnseignantNotFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EcoleNotFoundException.class)
    public @ResponseBody Map<String, String> handleException(EcoleNotFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AbsenceNouFoundException.class)
    public @ResponseBody Map<String, String> handleException(AbsenceNouFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FormationNotFoundException.class)
    public @ResponseBody Map<String, String> handleException(FormationNotFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GradeNotFoundException.class)
    public @ResponseBody Map<String, String> handleException(GradeNotFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServicesNotFoundException.class)
    public @ResponseBody Map<String, String> handleException(ServicesNotFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PersonnelAdministratifNotFoundExecption.class)
    public @ResponseBody Map<String, String> handleException(PersonnelAdministratifNotFoundExecption ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RoleUserNotFoundException.class)
    public @ResponseBody Map<String, String> handleException(RoleUserNotFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CongeNotFoundException.class)
    public @ResponseBody Map<String, String> handleException(CongeNotFoundException ex) {
        return Map.of("response", ex.getMessage());
    }

}