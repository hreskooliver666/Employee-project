package hu.nyirszikszi.employees.controller;

import hu.nyirszikszi.employees.dto.CreateEmployeeCommand;
import hu.nyirszikszi.employees.dto.EmployeeDto;
import hu.nyirszikszi.employees.dto.UpdateEmployeeCommand;
import hu.nyirszikszi.employees.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<EmployeeDto> list(@RequestParam(required = false) String department,
                                  @RequestParam(required = false) Integer minSalary){
        return service.list(department, minSalary);
    }

    @GetMapping("/{id}")
    public EmployeeDto get(@PathVariable long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable long id, @Valid @RequestBody UpdateEmployeeCommand command){
        return service.update(id, command);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }

}
