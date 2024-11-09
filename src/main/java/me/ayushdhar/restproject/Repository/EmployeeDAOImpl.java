package me.ayushdhar.restproject.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.ayushdhar.restproject.Entities.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager em;

    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        String jpqlQuery = "Select e from Employee e";
        TypedQuery<Employee> query = em.createQuery(jpqlQuery, Employee.class);
        return query.getResultList();
    }
}
