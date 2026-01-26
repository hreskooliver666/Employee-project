package hu.nyirszikszi.employees.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumValue {
    String message() default "Invalid enum value";
    Class<? extends Enum<?>> enumClass();
    boolean ignoreCase() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
