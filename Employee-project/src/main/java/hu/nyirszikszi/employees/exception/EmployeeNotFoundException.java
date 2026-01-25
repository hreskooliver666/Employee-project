package hu.nyirszikszi.employees.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long id) {
        super("Employee not found with id: " + id);
    }
}
