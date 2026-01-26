package hu.nyirszikszi.employees.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumValidator implements ConstraintValidator<EnumValue, String> {

    private String[] allowed;
    private boolean ignoreCase;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        this.ignoreCase = constraintAnnotation.ignoreCase();
        this.allowed = Arrays.stream(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .toArray(String[]::new);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;
        String v = value.trim();
        if (v.isEmpty()) return false;

        if (ignoreCase) {
            return Arrays.stream(allowed).anyMatch(a -> a.equalsIgnoreCase(v));
        }
        return Arrays.asList(allowed).contains(v);
    }
}
