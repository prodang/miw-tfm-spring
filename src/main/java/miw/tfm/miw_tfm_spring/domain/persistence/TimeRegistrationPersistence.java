package miw.tfm.miw_tfm_spring.domain.persistence;

import miw.tfm.miw_tfm_spring.domain.model.TimeRegistration;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TimeRegistrationPersistence {

    TimeRegistration create(TimeRegistration timeRegistration);

    TimeRegistration updateLeave(String id);

    Stream<TimeRegistration> findByIdEmployee(String dni);

    Stream<TimeRegistration> findAll();

    TimeRegistration update(String id, TimeRegistration timeRegistration);
}
