package hu.nyirszikszi.employees.service;

import hu.nyirszikszi.employees.domain.Department;
import hu.nyirszikszi.employees.domain.Employee;
import hu.nyirszikszi.employees.dto.CreateEmployeeCommand;
import hu.nyirszikszi.employees.dto.EmployeeDto;
import hu.nyirszikszi.employees.exception.DuplicateEmailException;
import hu.nyirszikszi.employees.repository.InMemoryEmployeeRepository;

import java.util.List;


public class EmployeeService {

    private final InMemoryEmployeeRepository repo;

    public EmployeeService(InMemoryEmployeeRepository repo) {
        this.repo = repo;
    }

    public EmployeeDto create(CreateEmployeeCommand cmd) {
        repo.findByEmailIgnoreCase(cmd.getEmail()).ifPresent( e -> {
            throw new DuplicateEmailException(cmd.getEmail());
        });

        Employee saved = repo.save(new Employee(
                0,
                cmd.getName().trim(),
                cmd.getEmail().trim(),
                cmd.getSalary(),
                cmd.getBirthDate(),
                Department.valueOf(cmd.getDepartment().trim().toUpperCase())
        ));
        return toDto(saved);
    }

    public List<EmployeeDto> list(String department, Integer minSalary) {
        boolean hasDept = department != null && !department.isBlank();
        boolean hasMin = minSalary != null;

        return repo.findAll().stream()
                .filter(e -> !hasDept || e.getDepartment() == Department.valueOf(department.trim().toUpperCase()))
                .filter( e -> !hasMin || e.getSalary() >= minSalary)
                .map(this::toDto)
                .toList();
    }

    private EmployeeDto toDto(Employee e) {
        return new EmployeeDto(
                e.getId(),
                e.getName(),
                e.getEmail(),
                e.getSalary(),
                e.getBirthDate(),
                e.getDepartment()
        );
    }

}
