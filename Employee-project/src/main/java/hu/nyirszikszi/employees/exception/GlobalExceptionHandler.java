package hu.nyirszikszi.employees.exception;

import com.sun.source.tree.BreakTree;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex){
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setType(URI.create("employees/validation-error"));
        pd.setTitle("Validation error");
        pd.setDetail("Request validation failed");

        List<Violation> violations = new ArrayList<>();
        for(FieldError fe : ex.getBindingResult().getFieldErrors()){
            violations.add(new Violation(fe.getField(), fe.getDefaultMessage()));
        }

        pd.setProperty("violations", violations);
        return pd;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail handleConstraintViolation(ConstraintViolationException ex){
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setType(URI.create("employees/validation-error"));
        pd.setTitle("Validation error");
        pd.setDetail("Request validation failed");

        List<Violation> violations = ex.getConstraintViolations().stream()
                .map(v -> new Violation(v.getPropertyPath().toString(), v.getMessage()))
                .toList();
        pd.setProperty("violations", violations);

        return pd;
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ProblemDetail handleNotFound(EmployeeNotFoundException ex){
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pd.setType(URI.create("employees/not-found"));
        pd.setTitle("Not found");
        pd.setDetail(ex.getMessage());

        return pd;
    }

}
