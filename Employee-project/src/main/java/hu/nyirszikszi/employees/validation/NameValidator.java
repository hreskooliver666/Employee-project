package hu.nyirszikszi.employees.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {

    private int maxLength;

    @Override
    public void initialize(Name constraintAnnotation) {
        this.maxLength = constraintAnnotation.maxLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // Update-nél opcionális
        String trimmed = value.trim();
        if (trimmed.isEmpty()) return false;
        if (trimmed.length() < 3) return false;
        if (trimmed.length() > maxLength) return false;
        return Character.isUpperCase(trimmed.charAt(0));
    }
}
