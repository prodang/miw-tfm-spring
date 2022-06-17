package miw.tfm.miw_tfm_spring.infraestructure.db.dao;

import miw.tfm.miw_tfm_spring.infraestructure.db.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface EmployeeDao extends JpaRepository <EmployeeEntity, String> {
    @Query("select u from EmployeeEntity u where u.identifier like %:id%")
    Stream<EmployeeEntity> searchById(String id);
}
