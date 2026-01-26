package hu.nyirszikszi.employees.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinAgeValidator.class)
public @interface MinAge {
    String message() default "Too young";
    int value();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
