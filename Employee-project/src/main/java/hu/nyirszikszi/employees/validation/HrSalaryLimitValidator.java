package hu.nyirszikszi.employees.validation;

import hu.nyirszikszi.employees.dto.CreateEmployeeCommand;
import hu.nyirszikszi.employees.dto.UpdateEmployeeCommand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HrSalaryLimitValidator implements ConstraintValidator<HrSalaryLimit, Object> {

    private int maxSalary;

    @Override
    public void initialize(HrSalaryLimit constraintAnnotation) {
        this.maxSalary = constraintAnnotation.maxSalary();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return true;

        String dept = null;
        Integer salary = null;

        if (value instanceof CreateEmployeeCommand c) {
            dept = c.getDepartment();
            salary = c.getSalary();
        } else if (value instanceof UpdateEmployeeCommand u) {
            dept = u.getDepartment();
            salary = u.getSalary();
        } else {
            return true;
        }

        if (dept == null || salary == null) return true;

        if ("HR".equalsIgnoreCase(dept.trim()) && salary > maxSalary) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("HR salary must be <= " + maxSalary)
                    .addPropertyNode("salary")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
