package hu.nyirszikszi.employees.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
public @interface Name {
    String message() default "Invalid name";
    int maxLength() default 50;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
