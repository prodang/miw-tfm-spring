package miw.tfm.miw_tfm_spring.infraestructure.db.persistence;

import miw.tfm.miw_tfm_spring.domain.exceptions.ConflictException;
import miw.tfm.miw_tfm_spring.domain.exceptions.NotFoundException;
import miw.tfm.miw_tfm_spring.domain.model.Employee;
import miw.tfm.miw_tfm_spring.domain.persistence.EmployeePersistence;
import miw.tfm.miw_tfm_spring.infraestructure.db.dao.EmployeeDao;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeePersistenceDB implements EmployeePersistence {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeePersistenceDB(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public List<Employee> findAll() {
        return this.employeeDao.findAll().stream()
                .map(EmployeeEntity::toEmployee)
                .collect(Collectors.toList());
    }

     public Employee findById(String id) {
        return this.employeeDao.findById(id)
                .map(EmployeeEntity::toEmployee)
                .orElseThrow(() -> new NotFoundException("The identifier don't exist: "+id));
    }

    public Employee create(Employee employee) {
        if(this.employeeDao.findById(employee.getIdentifier()).isPresent()){
            throw new ConflictException("The identifier already exist: "+employee.getIdentifier());
        }
        return this.employeeDao.save(new EmployeeEntity(employee)).toEmployee();
    }

}
