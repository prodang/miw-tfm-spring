package miw.tfm.miw_tfm_spring.infraestructure.db.dao;

import miw.tfm.miw_tfm_spring.domain.model.TimeRegistration;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.TimeRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface TimeRegistrationDao extends JpaRepository<TimeRegistrationEntity, String> {
    List<TimeRegistration> findByIdEmployee(String id);
}
