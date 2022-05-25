package miw.tfm.miw_tfm_spring.domain.persistence;

import miw.tfm.miw_tfm_spring.domain.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePersistence {

    List<Employee> findAll();
}
