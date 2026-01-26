package hu.nyirszikszi.employees.controller;

import hu.nyirszikszi.employees.dto.CreateEmployeeCommand;
import hu.nyirszikszi.employees.dto.EmployeeDto;
import hu.nyirszikszi.employees.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService service;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EmployeeDto create (@Valid @RequestBody CreateEmployeeCommand command){
        return service.create(command);
    }
    


}
