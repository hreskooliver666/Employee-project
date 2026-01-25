package hu.nyirszikszi.employees.dto;

import java.time.LocalDate;

public class CreateEmployeeCommand {
    
    private String name;
    private String email;
    private Integer salary;
    private LocalDate birthDate;
    private String department;

}
