package hu.nyirszikszi.employees.service;

import hu.nyirszikszi.employees.repository.InMemoryEmployeeRepository;


public class EmployeeService {

    private final InMemoryEmployeeRepository repo;

    public EmployeeService(InMemoryEmployeeRepository repo) {
        this.repo = repo;
    }
    

}
