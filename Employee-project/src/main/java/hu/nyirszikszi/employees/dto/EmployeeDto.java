package hu.nyirszikszi.employees.dto;

import hu.nyirszikszi.employees.domain.Department;

import java.time.LocalDate;

public record EmployeeDto(
        long id,
        String name,
        String email,
        int salary,
        LocalDate birthDate,
        Department department
) { }