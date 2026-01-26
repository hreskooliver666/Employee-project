package hu.nyirszikszi.employees.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {
    private int minAge;

    @Override
    public void initialize(MinAge constraintAnnotation) {
        this.minAge = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) return true;
        LocalDate latestAllowed = LocalDate.now().minusYears(minAge);
        return !value.isAfter(latestAllowed);
    }
}
