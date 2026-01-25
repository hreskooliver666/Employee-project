package hu.nyirszikszi.employees.service;

import hu.nyirszikszi.employees.domain.Employee;
import hu.nyirszikszi.employees.dto.EmployeeDto;
import hu.nyirszikszi.employees.repository.InMemoryEmployeeRepository;


public class EmployeeService {

    private final InMemoryEmployeeRepository repo;

    public EmployeeService(InMemoryEmployeeRepository repo) {
        this.repo = repo;
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
