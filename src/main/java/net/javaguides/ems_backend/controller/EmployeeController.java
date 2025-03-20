package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Department;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Build AddEmployee API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee by id Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Get employee by dept REST API
    @GetMapping("/department/{department}")
    public List<EmployeeDto> getEmployeesByDepartment(@PathVariable Department department){
        return employeeService.getEmployeesByDepartment(department);

    }

    //Build UpdateSalary API
    @PutMapping("/{id}/salary")
    public ResponseEntity<EmployeeDto> updateSalary(@PathVariable Long id,@RequestParam Double newSalary){
       EmployeeDto updatedEmployee = employeeService.updateSalary(id,newSalary);
       return ResponseEntity.ok(updatedEmployee);
    }
}
