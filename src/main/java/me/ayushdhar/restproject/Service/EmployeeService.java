package me.ayushdhar.restproject.Service;

import me.ayushdhar.restproject.Entities.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployee(int id);

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}
