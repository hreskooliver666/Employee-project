package hu.nyirszikszi.employees.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HrSalaryLimitValidator.class)
public @interface HrSalaryLimit {
    String message() default "HR salary too high";
    int maxSalary();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
