package me.ayushdhar.restproject.Controller;

import me.ayushdhar.restproject.Entities.Employee;
import me.ayushdhar.restproject.Repository.EmployeeDAO;
import me.ayushdhar.restproject.Service.EmployeeService;
import me.ayushdhar.restproject.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getALLEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee (@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee =  employeeService.getEmployee(id);
        if(employee!=null) return employee;
        else throw new RuntimeException("Employee with id " + id + " not found! Try Again!");
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        // should include exception handling
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " is deleted!";
    }
}
