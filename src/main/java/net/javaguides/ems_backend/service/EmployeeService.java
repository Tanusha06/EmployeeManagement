package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Department;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getEmployeesByDepartment(Department department);

    EmployeeDto updateSalary(Long id, Double newSalary);

}
