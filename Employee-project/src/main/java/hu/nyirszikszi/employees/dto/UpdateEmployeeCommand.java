package hu.nyirszikszi.employees.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class UpdateEmployeeCommand {

    @Name(maxLength = 50, message = "Name must start with an uppercase, length 3..50")
    private String name;

    @Email(message = "Email format is invalid")
    private String email;

    @Min(value = 1, message = "Salary must be at least 1")
    private Integer salary;

    @Past(message = "Birth date must be in the past")
    @MinAge(value = 16, message = "Employee must be at least 16 years old")
    private LocalDate birthDate;

    @EnumValue(enumClass = hu.nyirszikszi.employees.domain.Department.class, ignoreCase = true,
            message = "Department must be one of: HR, IT, FINANCE, SALES")
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
