package me.ayushdhar.restproject.Repository;

import me.ayushdhar.restproject.Entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getEmployees();
}
