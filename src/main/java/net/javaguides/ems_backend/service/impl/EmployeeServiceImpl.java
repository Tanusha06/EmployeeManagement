package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Department;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.exception.ResourceNotFoundException;
import net.javaguides.ems_backend.mapper.EmployeeMapper;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto); // converted employeeDto into Employee entity
        // Now save this JP entity into DB
        Employee savedEmployee = employeeRepository.save(employee);

        //converting saved JP entity into EmployeeDto
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with this id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee) ;
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartment(Department department) {
        List<Employee> employees = employeeRepository.findByDepartment(department); // fetching employees from repo.

        //convert list<employee> into list<employeedto>
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateSalary(Long id, Double newSalary) {
        if (newSalary<=0){
            throw new IllegalArgumentException("Salary must be positive");
        }
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setSalary(newSalary);
            Employee updatedEmployee = employeeRepository.save(employee);
            return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }


}
