package miw.tfm.miw_tfm_spring.infraestructure.db.dao;

import miw.tfm.miw_tfm_spring.domain.model.Employee;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository <EmployeeEntity, String> {
}
