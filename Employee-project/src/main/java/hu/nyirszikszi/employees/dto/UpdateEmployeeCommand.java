package hu.nyirszikszi.employees.dto;

import java.time.LocalDate;

public class UpdateEmployeeCommand {

    private String name;
    private String email;
    private Integer salary;
    private LocalDate birthDate;
    private String department;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getDepartment() {
        return department;
    }

}
