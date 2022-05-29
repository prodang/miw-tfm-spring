package miw.tfm.miw_tfm_spring.infraestructure.db.dao;

import miw.tfm.miw_tfm_spring.domain.model.TimeRegistration;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.TimeRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface TimeRegistrationDao extends JpaRepository<TimeRegistrationEntity, String> {
    Stream<TimeRegistration> findByIdEmployee(String dni);
}
