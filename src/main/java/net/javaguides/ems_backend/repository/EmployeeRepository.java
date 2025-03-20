package net.javaguides.ems_backend.repository;

import net.javaguides.ems_backend.entity.Department;
import net.javaguides.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(Department department);
}
