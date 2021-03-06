package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.domain.model.Employee;
import miw.tfm.miw_tfm_spring.domain.persistence.EmployeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class EmployeeService {

    private final EmployeePersistence employeePersistence;

    @Autowired
    public EmployeeService(EmployeePersistence employeePersistence){
        this.employeePersistence = employeePersistence;
    }


    public Stream<Employee> readAll() {
        return this.employeePersistence.findAll().stream();
    }

    public Employee readById(String id){
        return this.employeePersistence.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return this.employeePersistence.create(employee);
    }

    public void deleteEmployee(String id) {
        this.employeePersistence.delete(id);
    }

    public Employee updateEmployee(String identifier, Employee employee) {
        return this.employeePersistence.update(identifier, employee);
    }

    public Stream<Employee> searchById(String id) {
        return this.employeePersistence.searchById(id).stream();
    }
}
