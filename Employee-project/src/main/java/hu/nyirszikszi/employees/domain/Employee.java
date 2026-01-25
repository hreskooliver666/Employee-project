package hu.nyirszikszi.employees.domain;

import java.time.LocalDate;

public class Employee {

    private long id;
    private String name;
    private String email;
    private int salary;
    private LocalDate birthDate;
    private Department department;

    public Employee() {}

    public Employee(long id, String name, String email, int salary, LocalDate birthDate, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.birthDate = birthDate;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

}
