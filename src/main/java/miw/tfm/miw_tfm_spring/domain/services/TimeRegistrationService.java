package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.domain.model.TimeRegistration;
import miw.tfm.miw_tfm_spring.domain.persistence.TimeRegistrationPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TimeRegistrationService {

    private final TimeRegistrationPersistence timeRegistrationPersistence;

    @Autowired
    public TimeRegistrationService(TimeRegistrationPersistence timeRegistrationPersistence){
        this.timeRegistrationPersistence = timeRegistrationPersistence;
    }

    public TimeRegistration create(TimeRegistration timeRegistration){
        return this.timeRegistrationPersistence.create(timeRegistration);
    }

    public TimeRegistration updateLeave(String id) {
        return this.timeRegistrationPersistence.updateLeave(id);
    }

    public List<TimeRegistration> findByIdEmployee(String id) {
        return this.timeRegistrationPersistence.findByIdEmployee(id);
    }

    public Stream<TimeRegistration> findAll() {
        return this.timeRegistrationPersistence.findAll();
    }

    public TimeRegistration update(String id, TimeRegistration timeRegistration) {
        return this.timeRegistrationPersistence.update(id, timeRegistration);
    }
}
