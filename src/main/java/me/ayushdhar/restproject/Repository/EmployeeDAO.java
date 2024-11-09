package me.ayushdhar.restproject.Repository;

import me.ayushdhar.restproject.Entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getEmployees();

    public Employee getEmployee(int id);

    public Employee addEmployee(Employee employee);

//    public void updateEmployee(int id);

    public void deleteEmployee(int id);
}
