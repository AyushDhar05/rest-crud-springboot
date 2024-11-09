package me.ayushdhar.restproject.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.ayushdhar.restproject.Entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager em;

    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getEmployees() {
        String jpqlQuery = "Select e from Employee e";
        TypedQuery<Employee> query = em.createQuery(jpqlQuery, Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
//        em.persist(employee);
        return em.merge(employee);
    }


//    @Override
//    public void updateEmployee(int id) {
//        Employee emp = em.find(Employee.class, id);
//
//    }

    @Override
    public void deleteEmployee(int id) {
        Employee emp = em.find(Employee.class, id);
        em.remove(emp);
    }
}
